package fr.guddy.chatbotgateway.roombookings.domain;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public final class Timestamp {
    private final long value;

    public Timestamp(final long value) {
        this.value = value;
    }

    public Timestamp(final DateTime dateTime) {
        this(dateTime.getMillis() / 1000);
    }

    public Timestamp(final String isoDate) {
        this(
                ISODateTimeFormat.dateTimeNoMillis().parseDateTime(isoDate)
        );
    }

    public long value() {
        return value;
    }
}
