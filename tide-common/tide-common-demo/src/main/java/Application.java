import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author YangMingYang
 */
public class Application {

    public static void main(String[] args) throws SQLException {
        HikariConfig hikariConfig=new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:p6spy:mysql://localhost/cloud_music?serverTimezone=GMT%2B8");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("1");
        hikariConfig.setDriverClassName("com.p6spy.engine.spy.P6SpyDriver");
        DataSource dataSource=new HikariDataSource(hikariConfig);
        Connection conn=dataSource.getConnection();

    }

}
