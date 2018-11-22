package fr.guddy.chatbotgateway.roombookings.infra.requirements.common;

import javax.json.JsonObject;

public final class LocationRequirement implements Requirement<String> {
    private final JsonObject person;

    public LocationRequirement(final JsonObject person) {
        this.person = person;
    }

    @Override
    public String value() {
        return person.getString("raw");
    }
}
