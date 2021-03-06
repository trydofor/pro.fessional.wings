package pro.fessional.wings.slardar.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.slardar.context.TerminalInterceptor;
import pro.fessional.wings.slardar.servlet.resolver.WingsLocaleResolver;
import pro.fessional.wings.slardar.servlet.resolver.WingsRemoteResolver;
import pro.fessional.wings.slardar.spring.prop.SlardarEnabledProp;

/**
 * @author trydofor
 * @since 2019-06-29
 */
@Configuration
@ConditionalOnProperty(name = SlardarEnabledProp.Key$terminal, havingValue = "true")
public class SlardarTerminalConfiguration {

    private final Log logger = LogFactory.getLog(SlardarTerminalConfiguration.class);

    @Bean
    @ConditionalOnBean({WingsLocaleResolver.class, WingsRemoteResolver.class})
    public TerminalInterceptor terminalInterceptor(WingsLocaleResolver localeResolver, WingsRemoteResolver remoteResolver) {
        logger.info("Wings conf Terminal filter");
        return new TerminalInterceptor(localeResolver, remoteResolver);
    }
}
