package fr.guddy.chatbotgateway.roombookings.infra.mails;

import java.util.List;

public interface AuthorizedRecipients {
    List<String> addresses();

    default boolean contains(final String userId) {
        return addresses().contains(userId);
    }
}
