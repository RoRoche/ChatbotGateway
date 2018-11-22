package fr.guddy.chatbotgateway.roombookings.infra.requirements;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;

import javax.json.JsonObject;

public final class UserIdRequirement implements Requirement<String> {

    private final JsonObject userId;

    public UserIdRequirement(final JsonObject userId) {
        this.userId = userId;
    }

    @Override
    public String value() {
        return userId.getString("raw");
    }
}
