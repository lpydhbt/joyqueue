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
package com.jd.journalq.monitor;

/**
 * 分区信息
 * @author lining11
 * Date: 2018/9/13
 */
public class PartitionMonitorInfo extends BaseMonitorInfo {

    private String topic;
    private String app;
    private short partition;

    private EnQueueMonitorInfo enQueue;
    private DeQueueMonitorInfo deQueue;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public short getPartition() {
        return partition;
    }

    public void setPartition(short partition) {
        this.partition = partition;
    }

    public EnQueueMonitorInfo getEnQueue() {
        return enQueue;
    }

    public void setEnQueue(EnQueueMonitorInfo enQueue) {
        this.enQueue = enQueue;
    }

    public DeQueueMonitorInfo getDeQueue() {
        return deQueue;
    }

    public void setDeQueue(DeQueueMonitorInfo deQueue) {
        this.deQueue = deQueue;
    }
}