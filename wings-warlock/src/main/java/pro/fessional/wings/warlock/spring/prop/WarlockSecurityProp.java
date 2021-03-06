package pro.fessional.wings.warlock.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pro.fessional.wings.warlock.enums.autogen.UserStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static pro.fessional.mirana.cast.EnumConvertor.str2Enum;
import static pro.fessional.wings.warlock.enums.autogen.UserStatus.ACTIVE;

/**
 * wings-warlock-security-77.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-13
 */
@Data
@ConfigurationProperties(WarlockSecurityProp.Key)
public class WarlockSecurityProp {

    public static final String Key = "wings.warlock.security";

    /**
     * 权限是否使用Role
     *
     * @see #Key$authorityRole
     */
    private boolean authorityRole = true;
    public static final String Key$authorityRole = Key + ".authority-role";

    /**
     * 权限是否使用Perm
     *
     * @see #Key$authorityPerm
     */
    private boolean authorityPerm = false;
    public static final String Key$authorityPerm = Key + ".authority-perm";

    /**
     * true以servlet的forward进行，否则redirect(302)跳转
     *
     * @see #Key$loginForward
     */
    private boolean loginForward = true;
    public static final String Key$loginForward = Key + ".login-forward";

    /**
     * 未登录时跳转的页面，需要有controller处理
     *
     * @see #Key$loginPage
     */
    private String loginPage = "/auth/login-page.json";
    public static final String Key$loginPage = Key + ".login-page";

    /**
     * 处理登录的Ant格式URL（支持`{authType}`占位符，表示`*`），由filter处理，不需要controller
     *
     * @see #Key$loginUrl
     */
    private String loginUrl = "/auth/{authType}/login.json";
    public static final String Key$loginUrl = Key + ".login-url";

    /**
     * 登出地址，由filter处理，不需要controller
     *
     * @see #Key$logoutUrl
     */
    private String logoutUrl = "/auth/logout.json";
    public static final String Key$logoutUrl = Key + ".logout-url";

    /**
     * 登录成功返回的body
     *
     * @see #Key$loginSuccessBody
     */
    private String loginSuccessBody = "";
    public static final String Key$loginSuccessBody = Key + ".login-success-body";

    /**
     * 登录失败返回的body
     *
     * @see #Key$loginFailureBody
     */
    private String loginFailureBody = "";
    public static final String Key$loginFailureBody = Key + ".login-failure-body";

    /**
     * 登出成功返回的body
     * <p>
     * logout-success-body
     *
     * @see #Key$logoutSuccessBody
     */
    private String logoutSuccessBody = "";
    public static final String Key$logoutSuccessBody = Key + ".logout-success-body";

    /**
     * 同时登陆的session数
     *
     * @see #Key$sessionMaximum
     */
    private int sessionMaximum = 1;
    public static final String Key$sessionMaximum = Key + ".session-maximum";

    /**
     * 过期时返回的内容
     *
     * @see #Key$sessionExpiredBody
     */
    private String sessionExpiredBody = "";
    public static final String Key$sessionExpiredBody = Key + ".session-expired-body";

    /**
     * usernameParameter 名字
     *
     * @see #Key$usernamePara
     */
    private String usernamePara = "username";
    public static final String Key$usernamePara = Key + ".username-para";

    /**
     * passwordParameter 名字
     *
     * @see #Key$passwordPara
     */
    private String passwordPara = "password";
    public static final String Key$passwordPara = Key + ".password-para";

    /**
     * @see #Key$rolePrefix
     */
    private String rolePrefix = "ROLE_";
    public static final String Key$rolePrefix = Key + ".role-prefix";

    /**
     * @see #Key$authority
     */
    private Map<String, List<String>> authority = Collections.emptyMap();
    public static final String Key$authority = Key + ".authority";

    /**
     * 需要权限访问的路径，antMatcher，逗号分隔，斜杠换行
     *
     * @see #Key$authenticated
     */
    private List<String> authenticated = Collections.emptyList();
    public static final String Key$authenticated = Key + ".authenticated";

    /**
     * 无权限访问的路径，antMatcher，逗号分隔，斜杠换行
     *
     * @see #Key$permitAll
     */
    private List<String> permitAll = Collections.emptyList();
    public static final String Key$permitAll = Key + ".permit-all";

    /**
     * 支持的验证类型， enum全路径，一对一，否则反向解析有问题
     *
     * @see #Key$authType
     */
    private Map<String, String> authType = new HashMap<>();
    public static final String Key$authType = Key + ".auth-type";


    /**
     * 支持Nonce的验证类型
     *
     * @see #Key$nonceAuthType
     */
    private Set<String> nonceAuthType = Collections.emptySet();
    public static final String Key$nonceAuthType = Key + ".nonce-auth-type";

    /**
     * 默认的cache-manager bean name，同wings.slardar.cache.primary
     *
     * @see #Key$nonceCacheManager
     * @see pro.fessional.wings.slardar.cache.WingsCache.Manager
     */
    private String nonceCacheManager = "MemoryCacheManager";
    public static final String Key$nonceCacheManager = Key + ".nonce-cache-manager";

    /**
     * 默认使用的缓存leve
     *
     * @see #Key$nonceCacheLevel
     */
    private String nonceCacheLevel = "service";
    public static final String Key$nonceCacheLevel = Key + ".nonce-cache-level";


    /**
     * 支持自动注册用户的验证类型
     *
     * @see #Key$autoregAuthType
     */
    private Set<String> autoregAuthType = Collections.emptySet();
    public static final String Key$autoregAuthType = Key + ".autoreg-auth-type";

    /**
     * 最大连续失败次数，到达后锁账户
     *
     * @see #Key$autoregMaxFailed
     */
    private int autoregMaxFailed = 5;
    public static final String Key$autoregMaxFailed = Key + ".autoreg-max-failed";

    /**
     * 创建用户时，默认凭证过期时间
     *
     * @see #Key$autoregExpired
     */
    private Duration autoregExpired = Duration.ofDays(1000);
    public static final String Key$autoregExpired = Key + ".autoreg-expired";


    /**
     * 内存用户，key用户说明，重复时覆盖，建议为`username`+[`/`+`auth-type`]
     * auth-type=""或null时，为匹配全部auth-type，而"null"为Null类型
     * 其他设置，参考WarlockAuthnService.Details 的类型及默认值
     *
     * @see #Key$memUser
     */
    private Map<String, Mu> memUser = Collections.emptyMap();
    public static final String Key$memUser = Key + ".mem-user";

    /**
     * 内存用户权限，key授权说明，重复时覆盖，建议以类型和用途
     *
     * @see #Key$memAuth
     */
    private Map<String, Ma> memAuth = Collections.emptyMap();
    public static final String Key$memAuth = Key + ".mem-auth";

    @Data
    public static class Mu {
        private long userId;
        private String authType;
        private String username;
        private String password;
        private UserStatus status = ACTIVE;
        private String nickname;
        private String passsalt = "";
        private Locale locale = Locale.getDefault();
        private ZoneId zoneId = ZoneId.systemDefault();
        private LocalDateTime expired = LocalDateTime.MAX;
    }

    @Data
    public static class Ma {
        private long userId = -1;
        private String authType;
        private String username;
        private Set<String> authRole = Collections.emptySet();
        private Set<String> authPerm = Collections.emptySet();
    }

    // ////
    public Map<String, Enum<?>> mapAuthTypeEnum() {
        return authType.entrySet()
                       .stream()
                       .collect(toMap(Map.Entry::getKey, en -> str2Enum(en.getValue())));
    }

    public Set<Enum<?>> mapAutoregAuthEnum() {
        return autoregAuthType.stream().map(it -> {
            final String s = authType.get(it);
            if (s == null) throw new IllegalArgumentException("not found auth-type=" + it);
            return str2Enum(s);
        }).collect(Collectors.toSet());
    }

    public Set<Enum<?>> mapNonceAuthEnum() {
        return nonceAuthType.stream().map(it -> {
            final String s = authType.get(it);
            if (s == null) throw new IllegalArgumentException("not found auth-type=" + it);
            return str2Enum(s);
        }).collect(Collectors.toSet());
    }
}
