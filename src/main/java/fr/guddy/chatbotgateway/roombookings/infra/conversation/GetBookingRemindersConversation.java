package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;

public interface GetBookingRemindersConversation {
    Requirement<String> userId();
}
