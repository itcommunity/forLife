package lan.home.forlife.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by yar on 11.02.15.
 */
@Configuration
@Import(RepositoryRestMvcConfiguration.class)
public class RestConfig extends RepositoryRestMvcConfiguration{
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        log.info("Rest Configuration started");
        config.setBaseUri("/rest");
    }
}
