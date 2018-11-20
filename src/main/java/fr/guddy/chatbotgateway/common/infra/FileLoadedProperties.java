package fr.guddy.chatbotgateway.common.infra;

import io.vavr.control.Try;

import java.io.InputStream;
import java.util.Properties;
import java.util.function.Supplier;

public final class FileLoadedProperties implements LoadedProperties {

    private final Properties properties;

    public FileLoadedProperties(final Properties properties) {
        this.properties = properties;
    }

    public FileLoadedProperties(final Supplier<Properties> properties) {
        this(properties.get());
    }

    public FileLoadedProperties(final String fileName) {
        this(
                () ->
                        Try.of(() -> {
                                    final Properties prop = new Properties();
                                    try (
                                            final InputStream inputStream =
                                                    FileLoadedProperties.class.getClassLoader().getResourceAsStream(fileName)
                                    ) {
                                        prop.load(inputStream);
                                    }
                                    return prop;
                                }
                        ).get()
        );
    }

    @Override
    public Properties properties() {
        return properties;
    }
}
