package pro.fessional.wings.slardar.autozone.json;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import org.springframework.context.i18n.LocaleContextHolder;
import pro.fessional.mirana.time.DateLocaling;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author trydofor
 * @since 2019-09-01
 */
public class JacksonZonedDeserializer extends InstantDeserializer<ZonedDateTime> {

    public JacksonZonedDeserializer(DateTimeFormatter formatter) {
        super(ZonedDateTime.class,
                formatter,
                temporal -> {
                    final ZoneId zoneId = LocaleContextHolder.getTimeZone().toZoneId();
                    LocalDate date = LocalDate.from(temporal);
                    LocalTime time = LocalTime.from(temporal);
                    final ZonedDateTime zdt = ZonedDateTime.of(date, time, zoneId);
                    return DateLocaling.zoneZone(zdt, ZoneId.systemDefault());
                },
                a -> ZonedDateTime.ofInstant(Instant.ofEpochMilli(a.value), a.zoneId),
                a -> ZonedDateTime.ofInstant(Instant.ofEpochSecond(a.integer, a.fraction), a.zoneId),
                (zonedDateTime, zoneId) -> zonedDateTime,
                false // keep zero offset and Z separate since zones explicitly supported
        );
    }
}
