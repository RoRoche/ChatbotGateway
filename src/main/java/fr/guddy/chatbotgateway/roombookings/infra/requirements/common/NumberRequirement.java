package fr.guddy.chatbotgateway.roombookings.infra.requirements.common;

import javax.json.JsonObject;

public final class NumberRequirement implements Requirement<Integer> {

    private final JsonObject number;

    public NumberRequirement(final JsonObject number) {
        this.number = number;
    }

    @Override
    public Integer value() {
        return number.getInt("scalar");
    }
}
