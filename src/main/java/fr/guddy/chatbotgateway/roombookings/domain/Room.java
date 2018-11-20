package fr.guddy.chatbotgateway.roombookings.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.guddy.chatbotgateway.common.domain.AbstractDomainObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Room extends AbstractDomainObject {
    @JsonProperty("name")
    private String name;
    @JsonProperty("capacity")
    private Integer capacity;

    public Room() {
    }

    public Room(final String name, final Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }
}
