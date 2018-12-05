package fr.guddy.recastclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.guddy.recastclient.bot.Reply;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RecastResponse<R extends Reply> {
    private final List<R> replies;

    public RecastResponse(final List<R> replies) {
        this.replies = replies;
    }

    public RecastResponse(final R... replies) {
        this(
                List.of(replies)
        );
    }

    public List<R> getReplies() {
        return replies;
    }
}
