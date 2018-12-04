package fr.guddy.chatbotgateway.roombookings.infra.mails;

import org.apache.commons.mail.EmailException;

public final class BookingCancelledMail implements Mail {

    private final Mail mail;

    public BookingCancelledMail(final Mail mail) {
        this.mail = mail;
    }

    @Override
    public void send() throws EmailException {
        mail.send();
    }
}
