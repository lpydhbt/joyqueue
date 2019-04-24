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
package com.jd.journalq.nsr.network.command;

import com.jd.journalq.domain.Config;
import com.jd.journalq.network.transport.command.JournalqPayload;

import java.util.List;

/**
 * @author wylixiaobin
 * Date: 2019/1/29
 */
public class GetAllConfigsAck extends JournalqPayload {
    private List<Config> configs;

    public GetAllConfigsAck configs(List<Config> configs){
        this.configs = configs;
        return this;
    }

    public List<Config> getConfigs() {
        return configs;
    }

    @Override
    public int type() {
        return NsrCommandType.GET_ALL_CONFIG_ACK;
    }
}
