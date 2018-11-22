package fr.guddy.chatbotgateway.roombookings.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public final class TimestampTest {
    @Test
    public void testValidIsoDate() {
        // given
        final String isoDate = "2018-11-06T09:00:00Z";

        // when
        final Timestamp timestamp = new Timestamp(isoDate);

        // then
        Assertions.assertThat(timestamp.value()).isEqualTo(1541494800L);
    }
}