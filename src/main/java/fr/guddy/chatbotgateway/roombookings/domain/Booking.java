package fr.guddy.chatbotgateway.roombookings.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.guddy.chatbotgateway.common.domain.AbstractDomainObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Booking extends AbstractDomainObject {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("room")
    private Room room;
    @JsonProperty("slot")
    private Slot slot;

    public Booking() {
    }

    public Booking(final String userId, final Slot slot) {
        this.userId = userId;
        this.slot = slot;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(final Long id) {
        this.id = id;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @JsonProperty("room")
    public Room getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(final Room room) {
        this.room = room;
    }

    @JsonProperty("slot")
    public Slot getSlot() {
        return slot;
    }

    @JsonProperty("slot")
    public void setSlot(final Slot slot) {
        this.slot = slot;
    }
}
