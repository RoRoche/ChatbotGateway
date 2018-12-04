package fr.guddy.chatbotgateway.roombookings.infra.mails;

import org.apache.commons.mail.EmailException;

public interface Mail {
    void send() throws EmailException;
}
