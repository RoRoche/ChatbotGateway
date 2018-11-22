package fr.guddy.chatbotgateway.recast.bot;

import fr.guddy.chatbotgateway.common.infra.bot.SkillKey;
import io.javalin.Context;

import javax.json.Json;
import java.io.StringReader;

public final class RecastSkillKey implements SkillKey {
    private final String value;

    public RecastSkillKey(final String value) {
        this.value = value;
    }

    public RecastSkillKey(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getString("skill")
        );
    }

    @Override
    public String value() {
        return value;
    }
}
