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
package com.jd.journalq.broker.manage.service.support;

import com.google.common.collect.Lists;
import com.jd.journalq.broker.manage.service.ConnectionManageService;
import com.jd.journalq.network.session.Consumer;
import com.jd.journalq.network.session.Producer;
import com.jd.journalq.broker.monitor.SessionManager;

import java.util.List;

/**
 * ConnectionManageService
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/10/18
 */
public class DefaultConnectionManageService implements ConnectionManageService {

    private SessionManager sessionManager;

    public DefaultConnectionManageService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public int closeProducer(String topic, String app) {
        List<String> connectionIdList = Lists.newLinkedList();
        for (Producer producer : sessionManager.getProducer()) {
            if (producer.getTopic().equals(topic) && producer.getApp().equals(app)) {
                connectionIdList.add(producer.getConnectionId());
            }
        }
        for (String connectionId : connectionIdList) {
            sessionManager.getConnectionById(connectionId).getTransport().stop();
        }
        return connectionIdList.size();
    }

    @Override
    public int closeConsumer(String topic, String app) {
        List<String> connectionIdList = Lists.newLinkedList();
        for (Consumer consumer : sessionManager.getConsumer()) {
            if (consumer.getTopic().equals(topic) && consumer.getApp().equals(app)) {
                connectionIdList.add(consumer.getConnectionId());
            }
        }
        for (String connectionId : connectionIdList) {
            sessionManager.getConnectionById(connectionId).getTransport().stop();
        }
        return connectionIdList.size();
    }
}
