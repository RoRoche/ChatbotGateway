package fr.guddy.chatbotgateway.roombookings.infra.requirements.exceptions;

public final class MissingRequirementException extends RuntimeException {
    public MissingRequirementException(final String message) {
        super(message);
    }
}
