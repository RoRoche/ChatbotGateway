package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.recastclient.bot.Button;
import fr.guddy.recastclient.bot.SimpleButton;
import fr.guddy.recastclient.bot.Text;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

public final class BookRoomButton implements Button {

    private final Button delegate;

    public BookRoomButton(final Button delegate) {
        this.delegate = delegate;
    }

    public BookRoomButton(final Room room) {
        this(
                new SimpleRoomText(room),
                room
        );
    }

    public BookRoomButton(final Text title, final Room room) {
        this(
                new SimpleButton(
                        title,
                        String.format("Réserve-moi la salle %s", room.getName())
                )
        );
    }

    public BookRoomButton(final String title, final Room room) {
        this(
                new SimpleButton(
                        title,
                        String.format("Réserve-moi la salle %s", room.getName())
                )
        );
    }

    @Override
    public String getTitle() {
        return delegate.getTitle();
    }

    @Override
    public String getValue() {
        return delegate.getValue();
    }
}
