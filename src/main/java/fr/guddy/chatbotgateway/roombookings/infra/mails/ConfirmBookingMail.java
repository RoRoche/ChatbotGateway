package fr.guddy.chatbotgateway.roombookings.infra.mails;

import org.apache.commons.mail.EmailException;

public final class ConfirmBookingMail implements Mail {

    private final Mail mail;

    public ConfirmBookingMail(final Mail mail) {
        this.mail = mail;
    }

    @Override
    public void send() throws EmailException {
        mail.send();
    }
}
