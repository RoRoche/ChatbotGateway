package fr.guddy.chatbotgateway.roombookings.infra.mails;

public final class ConfirmBookingMail implements Mail {

    private final Mail mail;

    public ConfirmBookingMail(final Mail mail) {
        this.mail = mail;
    }

    @Override
    public void send() {
        mail.send();
    }
}
