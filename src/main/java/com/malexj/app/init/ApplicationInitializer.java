package com.malexj.app.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    /**
     * Path to config classes
     */
    private final static String CONFIG_LOCATION = "com.malexj.app.config";

    /**
     * Servlet congig
     */
    private final static String MAPPING_URL = "/";
    private final static String SERVLET_NAME = "DispatcherServlet";

    /**
     * Security congig
     */
    private final static String FILTER_NAME = "springSecurityFilterChain";
    private final static String TARGET_BEAN_NAME = "springSecurityFilterChain";
    private final static String URL_PATTERNS = "/*";

    /**
     * Multipart config
     */
    private final static String LOCATION = "";
    private final static long MAX_FILE_SIZE = 2000000;
    private final static long MAX_REQUEST_SIZE = 10000000;
    private final static int FILE_SIZE_THRESHOLD = 0;

    @Override
    public void onStartup(ServletContext servletContext) {

        // Create the 'root' Spring application context
        WebApplicationContext context = getContext();

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(context));

        // Security config
        servletContext.addFilter(FILTER_NAME, new DelegatingFilterProxy(TARGET_BEAN_NAME))
                .addMappingForUrlPatterns(null, false, URL_PATTERNS);

        // Create the dispatcher servlet's Spring application context
        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet(SERVLET_NAME, new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.setAsyncSupported(true);
        dispatcher.setMultipartConfig(getMultiPartConfigElement());
        dispatcher.addMapping(MAPPING_URL);
    }

    /**
     * Create the 'root' Spring application context and add config class
     */
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // path to config classes
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

    /**
     * Config multipart data
     */
    private MultipartConfigElement getMultiPartConfigElement() {
        return new MultipartConfigElement(LOCATION,
                MAX_FILE_SIZE,
                MAX_REQUEST_SIZE,
                FILE_SIZE_THRESHOLD);
    }
}
