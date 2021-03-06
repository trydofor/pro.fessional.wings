package pro.fessional.wings.silencer.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring-wings-enabled-79.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-13
 */
@Data
@ConfigurationProperties(SilencerEnabledProp.Key)
public class SilencerEnabledProp {

    public static final String Key = "spring.wings.silencer.enabled";

    /**
     * 是否显示wings的conditional信息
     *
     * @see #Key$verbose
     */
    private boolean verbose = false;
    public static final String Key$verbose = Key + ".verbose";

    /**
     * 是否自动加载 /wings-i18n/
     *
     * @see #Key$message
     */
    private boolean message = true;
    public static final String Key$message = Key + ".message";

    /**
     * 是否自动载所有classpath*下的 ** /spring/bean/ **
     *
     * @see #Key$scanner
     */
    private boolean scanner = true;
    public static final String Key$scanner = Key + ".scanner";
}
