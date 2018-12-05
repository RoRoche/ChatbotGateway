package fr.guddy.chatbotgateway.recast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.guddy.recastclient.bot.TextReply;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class RecastResponseTest {

    @Test
    public void testJsonSerialization() throws JsonProcessingException {
        // given
        final ObjectMapper objectMapper = new ObjectMapper();
        final RecastResponse<TextReply> recastRsp = new RecastResponse<>(
                new TextReply("Salle créée avec succès")
        );

        // when
        final String json = objectMapper.writeValueAsString(recastRsp);

        // then
        assertThat(json).isEqualToIgnoringCase(
                "{\"replies\":[{\"type\":\"text\",\"content\":\"Salle créée avec succès\"}]}"
        );
    }
}