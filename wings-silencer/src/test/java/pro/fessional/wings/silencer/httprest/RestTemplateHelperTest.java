package pro.fessional.wings.silencer.httprest;

import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pro.fessional.mirana.io.InputStreams;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static pro.fessional.wings.silencer.httprest.RestTestController.json;

/**
 * @author trydofor
 * @since 2020-06-03
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RestTemplateHelperTest {

    @Value("http://localhost:${local.server.port}")
    private String host;

    @Setter(onMethod = @__({@Autowired}))
    private RestTemplate restTemplate;


    @Test
    public void jsonEntity() {
        RestTestController.Json j1 = json();
        HttpEntity<RestTestController.Json> entity = RestTemplateHelper.jsonEntity(j1);
        ResponseEntity<RestTestController.Json> j2 = restTemplate.postForEntity(host + "/test/rest-template-helper-body.htm", entity, RestTestController.Json.class);
        assertEquals(j1, j2.getBody());
    }

    @Test
    public void formEntity() {
        HttpEntity<MultiValueMap<String, String>> form = RestTemplateHelper.formEntity();
        RestTemplateHelper.body(form).add("k1", "v1");
        ResponseEntity<String> rt = restTemplate.postForEntity(host + "/test/rest-template-helper-body.htm", form, String.class);
        assertEquals("k1=v1", rt.getBody());
    }

    @Test
    public void fileEntity() throws IOException {
        HttpEntity<MultiValueMap<String, Object>> form = RestTemplateHelper.fileEntity();
        String txt = "123456\nasdfgh";
        RestTemplateHelper.addFile(form, "up", new ByteArrayResource(txt.getBytes()), "test.txt");
        ResponseEntity<String> rt = restTemplate.postForEntity(host + "/test/rest-template-helper-file.htm", form, String.class);
        assertEquals(txt, rt.getBody());
    }

    @Test
    public void download() throws IOException {
        byte[] bytes = RestTemplateHelper.download(restTemplate, host + "/test/rest-template-helper-down.htm");
        String pom = InputStreams.readText(new FileInputStream("./pom.xml"));
        assertEquals(pom, new String(bytes));
    }
}