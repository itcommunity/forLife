package lan.home.forlife.configuration;

import lan.home.forlife.utils.DataSourceBuilder;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@ComponentScan("lan.home.forlife")
@EnableJpaRepositories("lan.home.forlife.repositories")
@EnableTransactionManagement
@PropertySource("classpath:/db.properties")
//@PropertySource("/WEB-INF/general.properties")
@EnableCaching
public class ModelConfiguration {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(environment);
        return dataSourceBuilder.getDataSource();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        String dbEngine=environment.getProperty("db.engine").replace("\"", "");
        switch (dbEngine){
            case "HSQL":
                vendorAdapter.setDatabase(Database.HSQL);
                break;
            case "POSTGRESQL":
                vendorAdapter.setDatabase(Database.POSTGRESQL);
                break;
            default:
                vendorAdapter.setDatabase(Database.HSQL);
                break;
        }
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        properties.setProperty("auto-import", "false");
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");


        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lan.home.forlife.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")));
        return cacheManager;
    }
}
