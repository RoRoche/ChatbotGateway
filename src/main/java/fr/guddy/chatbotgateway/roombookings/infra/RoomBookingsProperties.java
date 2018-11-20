package fr.guddy.chatbotgateway.roombookings.infra;

import fr.guddy.chatbotgateway.common.infra.FileLoadedProperties;

import java.util.Properties;

public final class RoomBookingsProperties implements RoomBookingsConfiguration {

    private final Properties properties;

    private RoomBookingsProperties(final Properties properties) {
        this.properties = properties;
    }

    public RoomBookingsProperties(final FileLoadedProperties properties) {
        this(properties.properties());
    }

    public RoomBookingsProperties() {
        this(
                new FileLoadedProperties("roombookings_config.properties")
        );
    }

    @Override
    public String baseUrl() {
        return properties.getProperty("baseUrl");
    }
}
