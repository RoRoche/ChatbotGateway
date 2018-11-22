package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Text;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

public final class CompleteRoomText implements Text {
    private final String value;

    public CompleteRoomText(final String value) {
        this.value = value;
    }

    public CompleteRoomText(final Room room) {
        this(
                String.format(
                        "%s (capacité: %d personnes)",
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
