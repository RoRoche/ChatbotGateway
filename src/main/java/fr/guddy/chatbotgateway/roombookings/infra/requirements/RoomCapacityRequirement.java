package fr.guddy.chatbotgateway.roombookings.infra.requirements;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.NumberRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;

import javax.json.JsonObject;

public final class RoomCapacityRequirement implements Requirement<Integer> {

    private final Requirement<Integer> delegate;

    public RoomCapacityRequirement(final Requirement<Integer> delegate) {
        this.delegate = delegate;
    }

    public RoomCapacityRequirement(final JsonObject capacity) {
        this(new NumberRequirement(capacity));
    }

    @Override
    public Integer value() {
        return delegate.value();
    }
}
