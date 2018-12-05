package fr.guddy.chatbotgateway.roombookings.infra.mails;

public final class BookingCancelledMail implements Mail {

    private final Mail mail;

    public BookingCancelledMail(final Mail mail) {
        this.mail = mail;
    }

    @Override
    public void send() {
        mail.send();
    }
}
