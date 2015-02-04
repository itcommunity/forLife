package lan.home.forlife.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[] {AppConfig.class, SecurityConfig.class};
//            return new Class[] {AppConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] { MvcConfig.class };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }

    }
