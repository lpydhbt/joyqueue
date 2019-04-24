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
package com.jd.journalq.broker.protocol.network.helper;

import com.jd.journalq.network.command.JournalqCommandType;
import com.jd.journalq.network.transport.codec.JournalqHeader;
import com.jd.journalq.network.transport.codec.JournalqHeaderCodec;
import io.netty.buffer.ByteBuf;

/**
 * JournalqProtocolHelper
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/11/28
 */
public class JournalqProtocolHelper {

    public static boolean isSupport(ByteBuf buffer) {
        if (buffer.readableBytes() < JournalqHeaderCodec.HEADER_LENGTH) {
            return false;
        }

        int size = buffer.readInt();
        int magic = buffer.readInt();
        byte version = buffer.readByte();
        byte identity = buffer.readByte();
        int requestId = buffer.readInt();
        byte type = buffer.readByte();

        return (size >= JournalqHeaderCodec.HEADER_LENGTH
                && magic == JournalqHeader.MAGIC
                && version >= 0
                && identity >= 0
                && requestId >= 0
                && JournalqCommandType.contains(type));
    }
}