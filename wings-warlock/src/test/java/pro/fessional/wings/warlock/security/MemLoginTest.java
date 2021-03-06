package pro.fessional.wings.warlock.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import pro.fessional.wings.slardar.httprest.OkHttpClientHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author trydofor
 * @since 2021-03-09
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class MemLoginTest {

    @Setter(onMethod_ = {@Value("${local.server.port}")})
    private int port;

    @Setter(onMethod_ = {@Autowired})
    private OkHttpClient okHttpClient;

    @Test
    public void testUsernameLogin() {
        final String host = "http://127.0.0.1:" + port;

        final Response r2 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/username/login.json?username=trydofor&password=moMxVKXxA8Pe9XX9"), false);
        String login = OkHttpClientHelper.extractString(r2, false);
        log.warn("get login res = " + login);
        Assertions.assertTrue(login.contains("true"));

        final Response r3 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/list-auth.json"), false);
        String au3 = OkHttpClientHelper.extractString(r3, false);
        log.warn("UsernameLogin auth3={}", au3);

        final Response r4 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/list-hold.json"), false);
        String au4 = OkHttpClientHelper.extractString(r4, false);
        log.warn("UsernameLogin auth4={}", au4);

        final Set<String> st3 = JSON.parseObject(au3, new TypeReference<Set<String>>() {});
        final Set<String> st4 = JSON.parseObject(au4, new TypeReference<Set<String>>() {});
        Assertions.assertEquals(st3, st4);

        Set<String> exp = new HashSet<>(Arrays.asList("ROLE_SYSTEM", "user-perm"));
        Assertions.assertEquals(exp, st3);
    }

    @Test
    public void testEmailLogin() {
        final String host = "http://127.0.0.1:" + port;

        final Response r2 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/email/login.json?username=trydofor@qq.com&password=3bvlPy7oQbds28c1"), false);
        String login = OkHttpClientHelper.extractString(r2, false);
        log.warn("get login res = " + login);
        Assertions.assertTrue(login.contains("true"));

        final Response r3 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/list-auth.json"), false);
        String au3 = OkHttpClientHelper.extractString(r3, false);
        log.warn("EmailLogin auth3={}", au3);

        final Response r4 = OkHttpClientHelper.execute(okHttpClient, new Request.Builder()
                .url(host + "/auth/list-hold.json"), false);
        String au4 = OkHttpClientHelper.extractString(r4, false);
        log.warn("EmailLogin auth4={}", au4);

        final Set<String> st3 = JSON.parseObject(au3, new TypeReference<Set<String>>() {});
        final Set<String> st4 = JSON.parseObject(au4, new TypeReference<Set<String>>() {});
        Assertions.assertEquals(st3, st4);

        Set<String> exp = new HashSet<>(Collections.singletonList("email-perm"));
        Assertions.assertEquals(exp, st3);
    }
}
