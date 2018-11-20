package fr.guddy.chatbotgateway.common.infra.bot;

public final class SkillNotManagedException extends RuntimeException {
    public SkillNotManagedException(final String key) {
        super(
                String.format(
                        "Skill for key '%s' not managed yet",
                        key
                )
        );
    }
}
