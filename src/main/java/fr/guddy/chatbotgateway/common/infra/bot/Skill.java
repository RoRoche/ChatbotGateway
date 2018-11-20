package fr.guddy.chatbotgateway.common.infra.bot;

import io.javalin.Context;

import java.io.IOException;

public interface Skill {
    void perform(final Context context) throws IOException;
}
