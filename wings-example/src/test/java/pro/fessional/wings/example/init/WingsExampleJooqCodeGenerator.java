package pro.fessional.wings.example.init;

import pro.fessional.wings.faceless.jooqgen.WingsCodeGenerator;

/**
 * @author trydofor
 * @since 2019-05-31
 */
public class WingsExampleJooqCodeGenerator {

    public static void main(String[] args) {
        String database = "wings_0";
        WingsCodeGenerator.builder()
                          .jdbcDriver("com.mysql.cj.jdbc.Driver")
                          .jdbcUrl("jdbc:mysql://127.0.0.1/" + database)
                          .jdbcUser("trydofor")
                          .jdbcPassword("moilioncircle")
                          .databaseSchema(database)
//                          .databaseIncludes(".*")
//                          .databaseExcludes(".*\\$log # 日志表\n"
//                                  + "| SPRING.* # Spring\n"
//                                  + "| SYS_SCALE_SEQUENCE # 特殊处理")
                          .databaseVersionProvider("SELECT MAX(revision) FROM sys_schema_version WHERE apply_dt > '1000-01-01'")
                          .targetPackage("pro.fessional.wings.example.database.autogen")
                          .targetDirectory("wings-example/src/main/java/")
                          .buildAndGenerate();
    }
}
