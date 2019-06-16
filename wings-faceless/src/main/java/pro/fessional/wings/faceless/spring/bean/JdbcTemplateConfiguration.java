package pro.fessional.wings.faceless.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import pro.fessional.wings.faceless.flywave.FlywaveDataSources;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author trydofor
 * @since 2019-06-25
 */
@Configuration
public class JdbcTemplateConfiguration {

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("plainJdbcTemplate")
    @ConditionalOnBean(FlywaveDataSources.class)
    public Map<String, JdbcTemplate> plainJdbcTemplate(@Autowired FlywaveDataSources dataSources) {
        LinkedHashMap<String, DataSource> plains = dataSources.plains();
        LinkedHashMap<String, JdbcTemplate> templates = new LinkedHashMap<>(plains.size());
        for (Map.Entry<String, DataSource> entry : plains.entrySet()) {
            templates.put(entry.getKey(), new JdbcTemplate(entry.getValue()));
        }
        return templates;
    }

}