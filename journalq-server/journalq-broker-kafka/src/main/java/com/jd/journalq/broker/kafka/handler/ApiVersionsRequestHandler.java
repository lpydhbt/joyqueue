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
package com.jd.journalq.broker.kafka.handler;

import com.google.common.collect.Lists;
import com.jd.journalq.broker.kafka.KafkaCommandType;
import com.jd.journalq.broker.kafka.KafkaErrorCode;
import com.jd.journalq.broker.kafka.command.ApiVersionsRequest;
import com.jd.journalq.broker.kafka.model.ApiVersion;
import com.jd.journalq.network.transport.command.Command;
import com.jd.journalq.network.transport.Transport;
import com.jd.journalq.broker.kafka.command.ApiVersionsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * ApiVersionsRequestHandler
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/11/5
 */
public class ApiVersionsRequestHandler extends AbstractKafkaCommandHandler {

    protected static final Logger logger = LoggerFactory.getLogger(ApiVersionsRequestHandler.class);

    private static final List<ApiVersion> APIS;
    private static final ApiVersionsResponse SUPPORTED_RESPONSE;

    static {
        List<ApiVersion> apis = Lists.newLinkedList();
        for (KafkaCommandType command : KafkaCommandType.values()) {
            if (command.isExport()) {
                apis.add(new ApiVersion(command.getCode(), command.getMinVersion(), command.getMaxVersion()));
            }
        }
        APIS = Collections.unmodifiableList(apis);
        SUPPORTED_RESPONSE = new ApiVersionsResponse(KafkaErrorCode.NONE.getCode(), APIS);
    }

    @Override
    public Command handle(Transport transport, Command command) {
        ApiVersionsRequest apiVersionsRequest = (ApiVersionsRequest) command.getPayload();

        // TODO 临时日志
        logger.debug("fetch api version, transport: {}, version: {}", transport.remoteAddress(), apiVersionsRequest.getVersion());
        return new Command(SUPPORTED_RESPONSE);
    }

    @Override
    public int type() {
        return KafkaCommandType.API_VERSIONS.getCode();
    }
}