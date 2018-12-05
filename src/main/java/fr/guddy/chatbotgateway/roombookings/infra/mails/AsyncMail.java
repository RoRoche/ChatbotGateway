package fr.guddy.chatbotgateway.roombookings.infra.mails;

public final class AsyncMail implements Mail {

    private final Mail delegate;

    public AsyncMail(final Mail delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send() {
        new Thread(delegate::send).start();
    }
}
