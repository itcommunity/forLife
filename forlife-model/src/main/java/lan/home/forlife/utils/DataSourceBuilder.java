package lan.home.forlife.utils;

import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by yar on 04.03.15.
 */
public class DataSourceBuilder {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    public DataSourceBuilder(Environment environment) {
        this.environment = environment;
    }

    public DataSource getDataSource() {
        String dbEngine = environment.getProperty("db.engine").replace("\"", "");
        log.info("Data Source property: " + dbEngine);
        DataSource dataSource;
        if (dbEngine.equals("H2")) {
            dataSource = getH2DataSource();
        } else if (dbEngine.equals("POSTGRESQL")) {

            dataSource = getPostgresqlDataSource();
        } else {
            dataSource = getH2DataSource();
        }
        return dataSource;
    }

    private DataSource getPostgresqlDataSource() {
        log.info("Loading Postgresql Data Source");
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("Postgresql Data Source");
        source.setServerName(environment.getProperty("db.postgresql.host").replace("\"", ""));
        source.setPortNumber(Integer.parseInt(environment.getProperty("db.postgresql.port").replace("\"", "")));
        source.setDatabaseName(environment.getProperty("db.name").replace("\"", ""));
        source.setUser(environment.getProperty("db.user").replace("\"", ""));
        source.setPassword(environment.getProperty("db.password").replace("\"", ""));
        source.setMaxConnections(Integer.parseInt(environment.getProperty("db.postgresql.max.connections").replace("\"", "")));
        return source;
    }

    private DataSource getH2DataSource() {
        log.info("Loading H2 Data Source");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }
}
