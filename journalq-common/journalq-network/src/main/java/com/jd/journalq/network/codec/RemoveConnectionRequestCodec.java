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

import com.jd.journalq.network.command.JournalqCommandType;
import com.jd.journalq.network.command.RemoveConnectionRequest;
import com.jd.journalq.network.transport.codec.JournalqHeader;
import com.jd.journalq.network.transport.codec.PayloadCodec;
import com.jd.journalq.network.transport.command.Type;
import io.netty.buffer.ByteBuf;

/**
 * RemoveConnectionRequestCodec
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/11/30
 */
public class RemoveConnectionRequestCodec implements PayloadCodec<JournalqHeader, RemoveConnectionRequest>, Type {

    @Override
    public RemoveConnectionRequest decode(JournalqHeader header, ByteBuf buffer) throws Exception {
        return new RemoveConnectionRequest();
    }

    @Override
    public void encode(RemoveConnectionRequest payload, ByteBuf buffer) throws Exception {
    }

    @Override
    public int type() {
        return JournalqCommandType.REMOVE_CONNECTION_REQUEST.getCode();
    }
}