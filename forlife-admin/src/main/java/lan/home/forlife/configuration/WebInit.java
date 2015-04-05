package lan.home.forlife.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic indexDispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        indexDispatcher.setLoadOnStartup(1);
		indexDispatcher.setAsyncSupported(true);
        indexDispatcher.addMapping("/");
        indexDispatcher.setAsyncSupported(true);
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("lan.home.forlife.configuration");
        return context;
    }
}
