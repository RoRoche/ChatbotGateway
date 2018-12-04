package fr.guddy.chatbotgateway.roombookings.infra.mails;

import java.util.List;

public final class StaticAuthorizedRecipients implements AuthorizedRecipients {
    @Override
    public List<String> addresses() {
        return List.of(
                "romain.rochegude@gmail.com"
        );
    }
}
