package fr.guddy.chatbotgateway.roombookings.infra.mails;

public final class EnvVarAuthentication implements Authentication {
    @Override
    public String user() {
        return System.getenv("GMAIL_USER");
    }

    @Override
    public String password() {
        return System.getenv("GMAIL_PASSWORD");
    }
}
