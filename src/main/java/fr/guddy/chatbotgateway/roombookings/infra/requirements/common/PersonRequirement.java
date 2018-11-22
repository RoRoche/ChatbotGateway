package fr.guddy.chatbotgateway.roombookings.infra.requirements.common;

import javax.json.JsonObject;

public final class PersonRequirement implements Requirement<String> {
    private final JsonObject person;

    public PersonRequirement(final JsonObject person) {
        this.person = person;
    }

    @Override
    public String value() {
        return person.getString("fullname");
    }
}
