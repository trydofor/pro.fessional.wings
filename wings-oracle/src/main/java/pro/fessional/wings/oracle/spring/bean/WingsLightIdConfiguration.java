package pro.fessional.wings.oracle.spring.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.mirana.id.LightIdBufferedProvider;
import pro.fessional.mirana.id.LightIdProvider;
import pro.fessional.wings.oracle.service.lightid.impl.LightIdMysqlLoader;
import pro.fessional.wings.oracle.spring.conf.WingsLightIdLoaderProperties;

/**
 * @author trydofor
 * @since 2019-06-01
 */
@Configuration
public class WingsLightIdConfiguration {

    @Bean
    @ConditionalOnMissingBean(LightIdProvider.class)
    public LightIdProvider lightIdProvider(LightIdMysqlLoader loader,
                                           WingsLightIdLoaderProperties config) {

        LightIdBufferedProvider provider = new LightIdBufferedProvider(loader);
        provider.setTimeout(config.getTimeout());
        provider.setErrAlive(config.getErrAlive());
        provider.setMaxError(config.getMaxError());
        provider.setMaxCount(config.getMaxCount());

        return provider;
    }
}