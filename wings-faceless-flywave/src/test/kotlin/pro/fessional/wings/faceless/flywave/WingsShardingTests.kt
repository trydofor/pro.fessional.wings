package pro.fessional.wings.faceless.flywave

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.sql.DataSource

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName::class)
open class WingsShardingTests {

    @Autowired
    lateinit var datasource: DataSource

    @Test
    fun test1DropTable() {
        val statement = datasource.connection.prepareStatement("""
            DROP TABLE IF EXISTS `WG_ORDER`;
        """.trimIndent())

        val result = statement.executeUpdate()
        println("=================== dropTable=$result")
    }

    @Test
    fun test2CreateTable() {
        val statement = datasource.connection.prepareStatement("""
            CREATE TABLE `WG_ORDER`
            (
              `ID`         bigint(20)   NOT NULL COMMENT '主键',
              `CREATE_DT`  datetime(3)     NOT NULL DEFAULT NOW(3) COMMENT '创建日时',
              `MODIFY_DT`  datetime(3)     NOT NULL DEFAULT '1000-01-01' ON UPDATE NOW(3) COMMENT '修改日时',
              `COMMIT_ID`  bigint(20)   NOT NULL COMMENT '提交ID',
              PRIMARY KEY (`ID`)
            ) ENGINE = InnoDB
              DEFAULT CHARSET = utf8mb4 COMMENT ='202/测试订单';
        """.trimIndent())

        val result = statement.executeUpdate()
        println("=================== createTable=$result")
    }

    @Test
    fun test3InsertDate() {
        val statement = datasource.connection.prepareStatement("""
            INSERT INTO `WG_ORDER` (`ID`,`COMMIT_ID`) VALUES
            (1, 1),
            (2, 1)
        """.trimIndent())

        val result = statement.executeUpdate()
        println("=================== insertDate=$result")
    }

    @Test
    fun test4AlterTable() {
        val statement = datasource.connection.prepareStatement("""
            ALTER TABLE `WG_ORDER`
            DROP COLUMN `COMMIT_ID`;
        """.trimIndent())

        val result = statement.executeUpdate()
        println("=================== alterTable=$result")
    }


    fun trigger() {
        val sts1 = datasource.connection.prepareStatement("""
            CREATE TABLE `WG_ORDER${"$"}LOG`
            (
              `ID`         bigint(20)   NOT NULL COMMENT '主键',
              `CREATE_DT`  datetime(3)     NOT NULL COMMENT '创建日时',
              `MODIFY_DT`  datetime(3)     NOT NULL COMMENT '修改日时',
              `COMMIT_ID`  bigint(20)   NOT NULL COMMENT '提交ID',
              `_du` INT(11) NULL,
              `_dt` datetime(3) DEFAULT NOW(3),
              `_id` INT(11) NOT NULL AUTO_INCREMENT,
              PRIMARY KEY (`_id`)
            ) ENGINE = InnoDB
              DEFAULT CHARSET = utf8mb4 COMMENT ='测试订单';
        """.trimIndent())

        val rst1 = sts1.executeUpdate()
        println("=================== trigger=$rst1")

        val sts2 = datasource.connection.prepareStatement("""
        CREATE TRIGGER `WG_ORDER${"$"}LOG_BU` BEFORE UPDATE ON `WG_ORDER_0`
        FOR EACH ROW BEGIN
          insert into `WG_ORDER${"$"}LOG` select *, 1 from `WG_ORDER_0` where id = OLD.id;
        END
        """.trimIndent())

        val rst2 = sts2.executeUpdate()
        println("=================== trigger=$rst2")
    }
}
