package fr.guddy.chatbotgateway.roombookings.infra.requirements.common;

import javax.json.JsonObject;

public final class SimpleNameRequirement implements Requirement<String> {
    private final JsonObject jsonObject;

    public SimpleNameRequirement(final JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String value() {
        return jsonObject.getString("raw");
    }
}
