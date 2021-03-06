package pro.fessional.wings.silencer.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.mirana.code.Crc8Long;
import pro.fessional.mirana.code.LeapCode;
import pro.fessional.wings.silencer.spring.prop.SilencerMiranaProp;

import java.util.Arrays;

/**
 * @author trydofor
 * @since 2019-06-26
 */
@Configuration
public class SilencerMiranaConfiguration {

    private static final Log logger = LogFactory.getLog(SilencerMiranaConfiguration.class);

    @Bean
    public Crc8Long crc8Long(SilencerMiranaProp conf) {
        int[] seed = conf.getCrc8Long();
        logger.info("Wings make Crc8Long, seed = " + Arrays.toString(seed));
        if (seed == null || seed.length == 0) {
            return new Crc8Long();
        } else {
            return new Crc8Long(seed);
        }
    }

    @Bean
    public LeapCode leapCode(SilencerMiranaProp conf) {
        String seed = conf.getLeapCode();
        logger.info("Wings make LeapCode, seed = " + seed);
        if (seed == null) {
            return new LeapCode();
        } else {
            return new LeapCode(seed);
        }
    }
}
