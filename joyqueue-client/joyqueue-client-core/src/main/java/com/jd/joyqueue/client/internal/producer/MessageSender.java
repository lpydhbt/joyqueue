/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jd.joyqueue.client.internal.producer;

import com.jd.joyqueue.client.internal.producer.callback.AsyncBatchSendCallback;
import com.jd.joyqueue.client.internal.producer.callback.AsyncMultiBatchSendCallback;
import com.jd.joyqueue.client.internal.producer.callback.AsyncSendCallback;
import com.jd.joyqueue.client.internal.producer.domain.FetchFeedbackData;
import com.jd.joyqueue.client.internal.producer.domain.ProduceMessage;
import com.jd.joyqueue.client.internal.producer.domain.SendBatchResultData;
import com.jd.joyqueue.client.internal.producer.domain.SendPrepareResult;
import com.jd.joyqueue.client.internal.producer.domain.SendResultData;
import com.jd.joyqueue.domain.QosLevel;
import com.jd.joyqueue.exception.JoyQueueCode;
import com.jd.joyqueue.network.command.TxStatus;
import com.jd.joyqueue.network.domain.BrokerNode;
import com.jd.joyqueue.toolkit.lang.LifeCycle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * MessageSender
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/12/10
 */
public interface MessageSender extends LifeCycle {

    SendResultData send(BrokerNode brokerNode, String topic, String app, String txId, ProduceMessage message, QosLevel qosLevel, long produceTimeout, long timeout);

    SendBatchResultData batchSend(BrokerNode brokerNode, String topic, String app, String txId, List<ProduceMessage> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    void sendAsync(BrokerNode brokerNode, String topic, String app, String txId, ProduceMessage message, QosLevel qosLevel, long produceTimeout, long timeout, AsyncSendCallback callback);

    void batchSendAsync(BrokerNode brokerNode, String topic, String app, String txId, List<ProduceMessage> messages,
                        QosLevel qosLevel, long produceTimeout, long timeout, AsyncBatchSendCallback callback);

    Future<SendBatchResultData> batchSendAsync(BrokerNode brokerNode, String topic, String app, String txId, List<ProduceMessage> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    // oneway
    void sendOneway(BrokerNode brokerNode, String topic, String app, String txId, ProduceMessage message, QosLevel qosLevel, long produceTimeout, long timeout);

    void batchSendOneway(BrokerNode brokerNode, String topic, String app, String txId, List<ProduceMessage> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    void batchSendOneway(BrokerNode brokerNode, String app, String txId, Map<String, List<ProduceMessage>> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    // batch
    Map<String, SendBatchResultData> batchSend(BrokerNode brokerNode, String app, String txId, Map<String, List<ProduceMessage>> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    void batchSendAsync(BrokerNode brokerNode, String app, String txId, Map<String, List<ProduceMessage>> messages,
                        QosLevel qosLevel, long produceTimeout, long timeout, AsyncMultiBatchSendCallback callback);

    Future<Map<String, SendBatchResultData>> batchSendAsync(BrokerNode brokerNode, String app, String txId,
                                                            Map<String, List<ProduceMessage>> messages, QosLevel qosLevel, long produceTimeout, long timeout);

    // transaction
    SendPrepareResult prepare(BrokerNode brokerNode, String topic, String app, String transactionId, long sequence, long transactionTimeout, long timeout);

    JoyQueueCode commit(BrokerNode brokerNode, String topic, String app, String txId, long timeout);

    JoyQueueCode rollback(BrokerNode brokerNode, String topic, String app, String txId, long timeout);

    FetchFeedbackData fetchFeedback(BrokerNode brokerNode, String topic, String app, TxStatus txStatus, int count, long longPollTimeout, long timeout);
}