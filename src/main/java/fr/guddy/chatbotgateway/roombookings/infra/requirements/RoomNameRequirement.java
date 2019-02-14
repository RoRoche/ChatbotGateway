package fr.guddy.chatbotgateway.roombookings.infra.requirements;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.LocationRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.PersonRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.SimpleNameRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.exceptions.MissingRequirementException;

import javax.json.JsonObject;
import java.util.Optional;
import java.util.stream.Stream;

public final class RoomNameRequirement implements Requirement<String> {

    private final Requirement<String> delegate;

    public RoomNameRequirement(final Requirement<String> delegate) {
        this.delegate = delegate;
    }

    public RoomNameRequirement(final JsonObject memory) {
        this(
                Stream.of(
                        Optional.ofNullable(memory.getJsonObject("person_name")).map(PersonRequirement::new),
                        Optional.ofNullable(memory.getJsonObject("location_name")).map(LocationRequirement::new),
                        Optional.ofNullable(memory.getJsonObject("name")).map(SimpleNameRequirement::new)
                )
        );
    }

    public RoomNameRequirement(final Stream<Optional<? extends Requirement<String>>> stream) {
        this(
                stream.filter(Optional::isPresent)
                        .findFirst()
                        .orElseThrow(() -> new MissingRequirementException("Il faut fournir le nom de la salle"))
                        .orElseThrow(() -> new MissingRequirementException("Il faut fournir le nom de la salle"))
        );
    }

    @Override
    public String value() {
        return delegate.value();
    }
}
