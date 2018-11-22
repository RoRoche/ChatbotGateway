package fr.guddy.chatbotgateway.recast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.guddy.chatbotgateway.recast.bot.Reply;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RecastResponse<R extends Reply> {
    @JsonProperty("replies")
    private final List<R> replies;

    public RecastResponse(final List<R> replies) {
        this.replies = replies;
    }

    public RecastResponse(final R... replies) {
        this(
                List.of(replies)
        );
    }

    @JsonProperty("replies")
    public List<R> getReplies() {
        return replies;
    }
}
