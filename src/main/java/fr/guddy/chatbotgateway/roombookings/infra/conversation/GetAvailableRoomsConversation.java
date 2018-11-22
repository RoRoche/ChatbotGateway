package fr.guddy.chatbotgateway.roombookings.infra.conversation;

public interface GetAvailableRoomsConversation {
    int capacity();

    long timestampStart();

    long timestampEnd();
}
