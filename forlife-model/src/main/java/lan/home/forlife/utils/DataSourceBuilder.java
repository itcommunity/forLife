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
        String dbEngine = getClearProperty("db.engine");
        log.info("Data Source property: " + dbEngine);
        DataSource dataSource;
        switch (dbEngine){
            case "H2":
                dataSource = getH2DataSource();
                break;
            case "HSQL":
                dataSource = getHSQLDataSource();
                break;
            case "POSTGRESQL":
                dataSource = getPostgresqlDataSource();
                break;
            default:
                dataSource=getHSQLDataSource();
                break;
        }
        return dataSource;
    }

    private DataSource getPostgresqlDataSource() {
        log.info("Loading Postgresql Data Source");
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("Postgresql Data Source");
        source.setServerName(getClearProperty("db.postgresql.host"));
        source.setPortNumber(Integer.parseInt(getClearProperty("db.postgresql.port")));
        source.setDatabaseName(getClearProperty("db.name"));
        source.setUser(getClearProperty("db.user"));
        source.setPassword(getClearProperty("db.password"));
        source.setMaxConnections(Integer.parseInt(getClearProperty("db.postgresql.max.connections")));
        return source;
    }

    private DataSource getH2DataSource() {
        log.info("Loading H2 Data Source");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    private DataSource getHSQLDataSource(){
        log.info("Loading HSQL Data Source");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    private String getClearProperty(String property){
        return environment.getProperty(property).replace("\"", "");
    }
}
