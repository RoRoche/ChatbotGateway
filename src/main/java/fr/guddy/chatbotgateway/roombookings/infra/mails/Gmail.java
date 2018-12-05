package fr.guddy.chatbotgateway.roombookings.infra.mails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Gmail implements Mail {
    private static final Logger LOGGER = LoggerFactory.getLogger(Gmail.class);

    private final Authentication authentication;
    private final String recipient;
    private final String subject;
    private final Message message;

    public Gmail(
            final Authentication authentication,
            final String recipient,
            final String subject,
            final Message message
    ) {
        this.authentication = authentication;
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void send() {
        // TODO
    }
}
