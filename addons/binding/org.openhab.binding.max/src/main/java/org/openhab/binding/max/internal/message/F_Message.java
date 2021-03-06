/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.max.internal.message;

import org.slf4j.Logger;

/**
 * The {@link: F_Message} contains information about the Cube NTP Configuration
 * This is the response to a f: command
 *
 * @author Marcel Verpaalen - Initial Version
 * @since 2.0.0
 */
public final class F_Message extends Message {

    private String ntpServer1 = "";
    private String ntpServer2 = "";

    /**
     * The {@link: F_Message} contains information about the Cube NTP Configuration
     *
     * @param raw String with raw message
     */
    public F_Message(String raw) {
        super(raw);

        final String[] servers = this.getPayload().split(",");
        if (servers.length > 0) {
            ntpServer1 = servers[0];
        }
        if (servers.length > 1) {
            ntpServer2 = servers[1];
        }
    }

    /**
     * @return the NTP Server1 name
     */
    public String getNtpServer1() {
        return ntpServer1;
    }

    /**
     * @return the NTP Server2 name
     */
    public String getNtpServer2() {
        return ntpServer2;
    }

    @Override
    public void debug(Logger logger) {
        logger.debug("=== F_Message === ");
        logger.trace("\tRAW : {}", this.getPayload());
        logger.debug("\tNTP Server1    : {}", this.ntpServer1);
        logger.debug("\tNTP Server2    : {}", this.ntpServer2);
    }

    @Override
    public MessageType getType() {
        return MessageType.F;
    }
}
