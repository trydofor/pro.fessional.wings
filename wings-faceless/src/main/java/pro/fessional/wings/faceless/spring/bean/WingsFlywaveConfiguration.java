package pro.fessional.wings.faceless.spring.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.wings.faceless.flywave.FlywaveDataSources;
import pro.fessional.wings.faceless.flywave.SchemaDefinitionLoader;
import pro.fessional.wings.faceless.flywave.SchemaJournalManager;
import pro.fessional.wings.faceless.flywave.SchemaShardingManager;
import pro.fessional.wings.faceless.flywave.SqlSegmentProcessor;
import pro.fessional.wings.faceless.flywave.SqlStatementParser;
import pro.fessional.wings.faceless.flywave.impl.DefaultRevisionManager;
import pro.fessional.wings.faceless.flywave.impl.MySqlStatementParser;
import pro.fessional.wings.faceless.flywave.impl.MysqlDefinitionLoader;
import pro.fessional.wings.faceless.spring.conf.WingsFlywaveSqlProperties;
import pro.fessional.wings.faceless.spring.conf.WingsFlywaveVerProperties;

/**
 * @author trydofor
 * @since 2019-06-01
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.wings.flywave", name = "enabled", havingValue = "true")
public class WingsFlywaveConfiguration {

    @Bean
    public SchemaJournalManager schemaJournalManager(
            FlywaveDataSources sources,
            SqlStatementParser statementParser,
            SqlSegmentProcessor segmentProcessor,
            SchemaDefinitionLoader schemaDefinitionLoader) {
        return new SchemaJournalManager(sources, statementParser, segmentProcessor, schemaDefinitionLoader);
    }

    @Bean
    public DefaultRevisionManager schemaVersionManger(
            FlywaveDataSources sources,
            SqlStatementParser statementParser,
            SqlSegmentProcessor segmentProcessor,
            SchemaDefinitionLoader schemaDefinitionLoader) {
        return new DefaultRevisionManager(sources, statementParser, segmentProcessor, schemaDefinitionLoader);
    }

    @Bean
    public SchemaShardingManager schemaShardingManager(
            FlywaveDataSources sources,
            SqlStatementParser statementParser,
            SqlSegmentProcessor segmentProcessor,
            SchemaDefinitionLoader schemaDefinitionLoader) {
        return new SchemaShardingManager(sources, statementParser, segmentProcessor, schemaDefinitionLoader);

    }

    @Bean
    public SqlStatementParser sqlStatementParser(WingsFlywaveSqlProperties properties) {
        if (properties.getDialect().equalsIgnoreCase("mysql")) {
            return new MySqlStatementParser();
        } else {
            throw new IllegalArgumentException("only support mysql");
        }
    }

    @Bean
    public SqlSegmentProcessor sqlSegmentParser(WingsFlywaveSqlProperties properties) {
        if (properties.getDialect().equalsIgnoreCase("mysql")) {
            return new SqlSegmentProcessor(properties.getCommentSingle(),
                    properties.getCommentMultiple(),
                    properties.getDelimiterDefault(),
                    properties.getDelimiterCommand());
        } else {
            throw new IllegalArgumentException("only support mysql");
        }
    }

    @Bean
    public SchemaDefinitionLoader schemaDefinitionLoader(WingsFlywaveSqlProperties properties) {
        if (properties.getDialect().equalsIgnoreCase("mysql")) {
            return new MysqlDefinitionLoader();
        } else {
            throw new IllegalArgumentException("only support mysql");
        }
    }

    @Bean
    @ConfigurationProperties("wings.flywave.sql")
    public WingsFlywaveSqlProperties sqlProperties() {
        return new WingsFlywaveSqlProperties();
    }

    @Bean
    @ConfigurationProperties("wings.flywave.ver")
    public WingsFlywaveVerProperties verProperties() {
        return new WingsFlywaveVerProperties();
    }
}
