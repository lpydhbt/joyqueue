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
package com.jd.journalq.client.internal;

import com.jd.journalq.client.internal.consumer.MessageConsumer;
import com.jd.journalq.client.internal.consumer.MessagePoller;
import com.jd.journalq.client.internal.consumer.config.ConsumerConfig;
import com.jd.journalq.client.internal.producer.MessageProducer;
import com.jd.journalq.client.internal.producer.callback.TxFeedbackCallback;
import com.jd.journalq.client.internal.producer.config.ProducerConfig;
import com.jd.journalq.client.internal.producer.feedback.config.TxFeedbackConfig;
import com.jd.journalq.toolkit.lang.LifeCycle;

/**
 * MessageAccessPoint
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2019/2/19
 */
public interface MessageAccessPoint extends LifeCycle {

    MessagePoller createPoller();

    MessagePoller createPoller(String group);

    MessagePoller createPoller(ConsumerConfig config);

    MessageConsumer createConsumer();

    MessageConsumer createConsumer(String group);

    MessageConsumer createConsumer(ConsumerConfig config);

    MessageProducer createProducer();

    MessageProducer createProducer(ProducerConfig config);

    void setTransactionCallback(String topic, TxFeedbackCallback callback);

    void setTransactionCallback(String topic, TxFeedbackConfig config, TxFeedbackCallback callback);

    void removeTransactionCallback(String topic);
}