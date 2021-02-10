package com.danfoss.cloud.prosa.avro.utils;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility functions the consumer need when working with Avro classes.
 */
public interface AvroFunctions {


    /**
     * Converts {@link String} date ISO-formatted into a {@link Instant}.
     *
     * @param date the date (nullable).
     * @return the resulting {@link Instant}.
     */
    static Optional<Instant> toInstant(String date) {
        if (StringUtils.isEmpty(date))
            return Optional.empty();
        return Optional.of(Instant.parse(date));
    }

    /**
     * Converts {@link String} uuid into a {@link UUID}.
     *
     * @param uuid the uuid (nullable).
     * @return the resulting {@link UUID}.
     */
    static Optional<UUID> toUUID(String uuid) {
        if (StringUtils.isEmpty(uuid))
            return Optional.empty();
        return Optional.of(UUID.fromString(uuid));
    }

}
