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
package com.jd.journalq.network.codec;

import com.jd.journalq.network.command.FetchHealthResponse;
import com.jd.journalq.network.command.JournalqCommandType;
import com.jd.journalq.network.transport.codec.JournalqHeader;
import com.jd.journalq.network.transport.codec.PayloadCodec;
import com.jd.journalq.network.transport.command.Type;
import io.netty.buffer.ByteBuf;

/**
 * FetchHealthResponseCodec
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/12/28
 */
public class FetchHealthResponseCodec implements PayloadCodec<JournalqHeader, FetchHealthResponse>, Type {

    @Override
    public Object decode(JournalqHeader header, ByteBuf buffer) throws Exception {
        double point = buffer.readDouble();
        FetchHealthResponse fetchHealthResponse = new FetchHealthResponse();
        fetchHealthResponse.setPoint(point);
        return fetchHealthResponse;
    }

    @Override
    public void encode(FetchHealthResponse payload, ByteBuf buffer) throws Exception {
        buffer.writeDouble(payload.getPoint());
    }

    @Override
    public int type() {
        return JournalqCommandType.FETCH_HEALTH_RESPONSE.getCode();
    }
}