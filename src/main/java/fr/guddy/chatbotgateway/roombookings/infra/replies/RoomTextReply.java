package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

public final class RoomTextReply implements Reply<String> {

    private final Reply<String> delegate;

    public RoomTextReply(final Reply<String> delegate) {
        this.delegate = delegate;
    }

    public RoomTextReply(final Room room) {
        this(
                new TextReply(
                        new CompleteRoomText(room)
                )
        );
    }

    @Override
    public String getType() {
        return delegate.getType();
    }

    @Override
    public String getContent() {
        return delegate.getContent();
    }
}
