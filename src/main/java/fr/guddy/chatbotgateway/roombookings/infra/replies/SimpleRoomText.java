package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Text;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

public final class SimpleRoomText implements Text {
    private final String value;

    public SimpleRoomText(final String value) {
        this.value = value;
    }

    public SimpleRoomText(final Room room) {
        this(
                String.format(
                        "%s (%d)",
                        room.getName(),
                        room.getCapacity()
                )
        );
    }

    @Override
    public String value() {
        return value;
    }
}
