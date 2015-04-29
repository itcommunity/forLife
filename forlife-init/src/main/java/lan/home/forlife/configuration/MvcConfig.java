package lan.home.forlife.configuration;

import lan.home.forlife.utils.ApiVersionRequestMappingHandlerMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;

/**
 * Created by yar on 10.02.15.
 */
@Configuration
//@EnableWebMvc
@ComponentScan("lan.home.forlife")
public class MvcConfig extends WebMvcConfigurationSupport {
//public class MvcConfig extends WebMvcConfigurerAdapter {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setSuffix(".jpg");
//        viewResolver.setPrefix("/tmp/MyFiles");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        ResourceHandlerRegistration registration = registry.addResourceHandler("/static/**");
        registration.addResourceLocations("/WEB-INF/static/");
//        ResourceHandlerRegistration imageRegistration = registry.addResourceHandler("/photo/**");
//        imageRegistration.addResourceLocations(env.getProperty("photo.storage.location"));
//        registration.addResourceLocations("/WEB-INF/static/js/", "/WEB-INF/static/css/");
        registration.setCachePeriod(0);
    }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new ApiVersionRequestMappingHandlerMapping("/api1");
    }
}