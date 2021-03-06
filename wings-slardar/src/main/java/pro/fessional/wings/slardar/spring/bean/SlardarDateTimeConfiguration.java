package pro.fessional.wings.slardar.spring.bean;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.slardar.autozone.spring.LocalDate2StringConverter;
import pro.fessional.wings.slardar.autozone.spring.LocalDateTime2StringConverter;
import pro.fessional.wings.slardar.autozone.spring.LocalTime2StringConverter;
import pro.fessional.wings.slardar.autozone.spring.String2LocalDateConverter;
import pro.fessional.wings.slardar.autozone.spring.String2LocalDateTimeConverter;
import pro.fessional.wings.slardar.autozone.spring.String2LocalTimeConverter;
import pro.fessional.wings.slardar.autozone.spring.String2ZonedDateTimeConverter;
import pro.fessional.wings.slardar.autozone.spring.ZonedDateTime2StringConverter;
import pro.fessional.wings.slardar.spring.prop.SlardarDatetimeProp;
import pro.fessional.wings.slardar.spring.prop.SlardarEnabledProp;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

/**
 * 通过 ApplicationConversionService#addBeans 自动注入
 *
 * @author trydofor
 * @see ApplicationConversionService#addBeans
 * @since 2019-12-03
 */
@Configuration
@ConditionalOnProperty(name = SlardarEnabledProp.Key$datetime, havingValue = "true")
@RequiredArgsConstructor
public class SlardarDateTimeConfiguration {
    private static final Log logger = LogFactory.getLog(SlardarDateTimeConfiguration.class);

    private final SlardarDatetimeProp slardarDatetimeProp;

    // spring boot can expose Beans instead of WebMvcConfigurer
    @Bean
    public String2LocalDateConverter stringLocalDateConverter() {
        logger.info("Wings conf stringLocalDateConverter");
        val fmt = slardarDatetimeProp.getDate()
                                     .getSupport()
                                     .stream()
                                     .map(DateTimeFormatter::ofPattern)
                                     .collect(Collectors.toList());
        return new String2LocalDateConverter(fmt);
    }

    @Bean
    public LocalDate2StringConverter localDateStringConverter() {
        logger.info("Wings conf localDateStringConverter");
        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(slardarDatetimeProp.getDate().getFormat());
        return new LocalDate2StringConverter(fmt);
    }

    @Bean
    public String2LocalTimeConverter stringLocalTimeConverter() {
        logger.info("Wings conf stringLocalTimeConverter");
        val fmt = slardarDatetimeProp.getTime()
                                     .getSupport()
                                     .stream()
                                     .map(DateTimeFormatter::ofPattern)
                                     .collect(Collectors.toList());
        return new String2LocalTimeConverter(fmt);
    }

    @Bean
    public LocalTime2StringConverter localTimeStringConverter() {
        logger.info("Wings conf localTimeStringConverter");
        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(slardarDatetimeProp.getTime().getFormat());
        return new LocalTime2StringConverter(fmt);
    }

    @Bean
    public String2LocalDateTimeConverter stringLocalDateTimeConverter() {
        logger.info("Wings conf stringLocalDateTimeConverter");
        val fmt = slardarDatetimeProp.getDatetime()
                                     .getSupport()
                                     .stream()
                                     .map(DateTimeFormatter::ofPattern)
                                     .collect(Collectors.toList());
        return new String2LocalDateTimeConverter(fmt);
    }

    @Bean
    public LocalDateTime2StringConverter localDateTimeStringConverter() {
        logger.info("Wings conf localDateTimeStringConverter");
        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(slardarDatetimeProp.getDatetime().getFormat());
        return new LocalDateTime2StringConverter(fmt);
    }

    @Bean
    public String2ZonedDateTimeConverter stringZonedDateTimeConverter() {
        logger.info("Wings conf stringZonedDateTimeConverter");
        val fmt = slardarDatetimeProp.getZoned()
                                     .getSupport()
                                     .stream()
                                     .map(DateTimeFormatter::ofPattern)
                                     .collect(Collectors.toList());
        return new String2ZonedDateTimeConverter(fmt);
    }

    @Bean
    public ZonedDateTime2StringConverter zonedDateTimeStringConverter() {
        logger.info("Wings conf zonedDateTimeStringConverter");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(slardarDatetimeProp.getZoned().getFormat());
        return new ZonedDateTime2StringConverter(fmt);
    }
}
