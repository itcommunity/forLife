package lan.home.forlife.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yar on 10.02.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan("lan.home.forlife")
public class MvcConfig extends WebMvcConfigurerAdapter {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}