package pro.fessional.wings.faceless.sample

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import pro.fessional.wings.faceless.flywave.SchemaRevisionManager
import pro.fessional.wings.faceless.util.FlywaveRevisionSqlScanner

/**
 * @author trydofor
 * @since 2019-06-22
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("init")
class WingsFlywaveInitDatabaseSample {

    @Autowired
    lateinit var schemaRevisionManager: SchemaRevisionManager

    @Test
    fun init520() {
        // 初始
        val sqls = FlywaveRevisionSqlScanner.scan(SchemaRevisionManager.REVISIONSQL_PATH)
        schemaRevisionManager.checkAndInitSql(sqls, 0)

        // 升级
        schemaRevisionManager.publishRevision(2019052001, 0)
    }
}