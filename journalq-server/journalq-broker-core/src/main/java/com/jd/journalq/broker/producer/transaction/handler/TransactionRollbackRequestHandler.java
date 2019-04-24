package com.jd.journalq.broker.producer.transaction.handler;

import com.jd.journalq.broker.BrokerContext;
import com.jd.journalq.broker.producer.Produce;
import com.jd.journalq.broker.producer.transaction.command.TransactionRollbackRequest;
import com.jd.journalq.exception.JournalqCode;
import com.jd.journalq.exception.JournalqException;
import com.jd.journalq.message.BrokerRollback;
import com.jd.journalq.network.command.BooleanAck;
import com.jd.journalq.network.command.CommandType;
import com.jd.journalq.network.session.Producer;
import com.jd.journalq.network.transport.Transport;
import com.jd.journalq.network.transport.command.Command;
import com.jd.journalq.network.transport.command.Type;
import com.jd.journalq.network.transport.command.handler.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TransactionRollbackRequestHandler
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2019/4/12
 */
public class TransactionRollbackRequestHandler implements CommandHandler, Type {

    protected static final Logger logger = LoggerFactory.getLogger(TransactionRollbackRequestHandler.class);

    private Produce produce;

    public TransactionRollbackRequestHandler(BrokerContext brokerContext) {
        this.produce = brokerContext.getProduce();
    }

    @Override
    public Command handle(Transport transport, Command command) {
        TransactionRollbackRequest transactionRollbackRequest = (TransactionRollbackRequest) command.getPayload();
        Producer producer = new Producer(transactionRollbackRequest.getTopic(), transactionRollbackRequest.getTopic(), transactionRollbackRequest.getApp(), Producer.ProducerType.JMQ);

        BrokerRollback brokerRollback = new BrokerRollback();
        brokerRollback.setTopic(transactionRollbackRequest.getTopic());
        brokerRollback.setApp(transactionRollbackRequest.getApp());
        brokerRollback.setTxId(transactionRollbackRequest.getTxId());

        try {
            produce.putTransactionMessage(producer, brokerRollback);
            return BooleanAck.build();
        } catch (JournalqException e) {
            logger.error("rollback transaction exception, topic: {}, app: {}", transactionRollbackRequest.getTopic(), transactionRollbackRequest.getApp(), e);
            return BooleanAck.build(e.getCode());
        } catch (Exception e) {
            logger.error("rollback transaction exception, topic: {}, app: {}", transactionRollbackRequest.getTopic(), transactionRollbackRequest.getApp(), e);
            return BooleanAck.build(JournalqCode.CN_UNKNOWN_ERROR);
        }
    }

    @Override
    public int type() {
        return CommandType.TRANSACTION_ROLLBACK_REQUEST;
    }
}