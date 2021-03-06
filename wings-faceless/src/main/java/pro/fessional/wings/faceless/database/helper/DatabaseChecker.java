package pro.fessional.wings.faceless.database.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * mysql服务器，程序，会话时区
 * https://dev.mysql.com/doc/refman/8.0/en/time-zone-support.html#time-zone-variables
 *
 * @author trydofor
 * @since 2021-04-14
 */
@Slf4j
public class DatabaseChecker {

    /**
     * 如果不一致，抛出 IllegalStateException
     *
     * @param ds jdbc template
     */
    public static void timezone(DataSource ds) {

        final String zdt = "1979-01-01T00:00:00";
        final LocalDateTime ldt = LocalDateTime.parse(zdt);
        final String sql = "SELECT @@system_time_zone,  @@global.time_zone, @@session.time_zone,"
                           + "TIMESTAMPDIFF(SECOND,'" + zdt.replace('T', ' ') + "', ?) from dual;";

        final JdbcTemplate tmpl = new JdbcTemplate(ds);

        tmpl.query(sql, rs -> {
            final StringBuilder sb = new StringBuilder();
            sb.append("\nsystem_time_zone=").append(rs.getString(1));
            sb.append("\nglobal.time_zone=").append(rs.getString(2));
            sb.append("\nsession.time_zone=").append(rs.getString(3));
            sb.append("\njvm-timezone=").append(ZoneId.systemDefault().getId());

            final int off = rs.getInt(4);

            sb.append("\nZoneOffset=").append(ZoneOffset.ofTotalSeconds(off));

            log.info(sb.substring(1).replace("\n", ", "));

            if (off == 0) {
                return;
            }

            sb.append("\n=== DIFF TIMEZONE===");
            sb.append("\nthe flowing can make session at same zone.");
            sb.append("\n - mysql server `default-time-zone = '+08:00'`");
            sb.append("\n - jdbc url `?serverTimezone=Asia/Shanghai`");
            sb.append("\n - wings conf `wings.silencer.i18n.zoneid=Asia/Shanghai`");
            sb.append("\n - java args `-Duser.timezone=Asia/Shanghai`");
            sb.append("\n - java code `TimeZone.setDefault(TimeZone.getTimeZone(\"Asia/Shanghai\"));`");

            throw new IllegalStateException(sb.toString());
        }, Timestamp.valueOf(ldt));
    }

    public static void version(DataSource ds) {
        final JdbcTemplate tmpl = new JdbcTemplate(ds);
        String ver = "SELECT version() FROM dual";
        tmpl.query(ver, rs -> {
            log.info("mysql version={}", rs.getString(1));
        });

        String rev = "SELECT max(revision) FROM sys_schema_version WHERE apply_dt > '1111-11-11'";
        try {
            tmpl.query(rev, rs -> {
                log.info("flywave revision={}", rs.getString(1));
            });
        }
        catch (DataAccessException e) {
            log.info("flywave revision is unknown, for no sys_schema_version");
        }
    }
}
