package pro.fessional.wings.slardar.spring.prop;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.ParameterType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author trydofor
 * @see #Key
 * @since 2021-02-14
 */
@Data
@ConfigurationProperties(SlardarSwaggerProp.Key)
public class SlardarSwaggerProp {

    public static final String Key = "wings.slardar.swagger";

    /**
     * wings中，默认docket的设置
     *
     * @see #Key$api
     */
    private Api api = new Api();

    public static final String Key$api = Key + ".api";

    /**
     * `**` 为 `any`，支持逗号`,`分隔
     *
     * @see #Key$group
     */
    private Map<String, Grp> group = new HashMap<>();
    public static final String Key$group = Key + ".group";

    /**
     * @see #Key$param
     */
    private Map<String, Par> param = new HashMap<>();
    public static final String Key$param = Key + ".param";


    /**
     * 在ApiMode中使用全类名的，而非SimpleName
     *
     * @see #Key$model
     */
    private Mdl model = new Mdl();
    public static final String Key$model = Key + ".model";

    @Data
    public static class Api {
        /**
         * docket的标题
         */
        private String title;

        /**
         * docket的描述
         */
        private String description;

        /**
         * docket的版本
         */
        private String version;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Grp extends Api {

        private boolean enable = true;

        private String host = null;
        /**
         * package prefix
         */
        private Set<String> basePackage = Collections.emptySet();

        /**
         * ant path
         */
        private Set<String> antPath = Collections.emptySet();
    }

    @Data
    public static class Par {
        private boolean enable = true;
        private ParameterType type;
        private String value = "";
        private String description = "";
    }

    @Data
    public static class Mdl {
        private Set<String> canonical = Collections.emptySet();
        private boolean annotation = false;
    }
}
