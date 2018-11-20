package fr.guddy.chatbotgateway.roombookings.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.guddy.chatbotgateway.common.domain.AbstractDomainObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Slot extends AbstractDomainObject {
    @JsonProperty("timestamp_start")
    private Long timestampStart;
    @JsonProperty("timestamp_end")
    private Long timestampEnd;

    public Slot() {
    }

    public Slot(final Long timestampStart, final Long timestampEnd) {
        this.timestampStart = timestampStart;
        this.timestampEnd = timestampEnd;
    }

    @JsonProperty("timestamp_start")
    public Long getTimestampStart() {
        return timestampStart;
    }

    @JsonProperty("timestamp_start")
    public void setTimestampStart(final Long timestampStart) {
        this.timestampStart = timestampStart;
    }

    @JsonProperty("timestamp_end")
    public Long getTimestampEnd() {
        return timestampEnd;
    }

    @JsonProperty("timestamp_end")
    public void setTimestampEnd(final Long timestampEnd) {
        this.timestampEnd = timestampEnd;
    }
}
