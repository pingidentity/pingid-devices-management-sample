package com.pingid.dm.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class Config implements ServletContextListener {

    private static final String ATTRIBUTE_NAME = "config";
    private static final String PROP_FILE = "properties/config.properties";
    private static final List<String> PROPS_NAMES =
            Arrays.asList("use_base64_key","use_signature","token","idp_url","org_alias","admin_url","authenticator_url");

    private final Properties config = new Properties();

    @Override
    public void contextInitialized(ServletContextEvent event) {

        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Loading config failed", e);
        }

        Enumeration<?> properties = config.propertyNames();

        if (!properties.hasMoreElements()){
            throw new RuntimeException(PROP_FILE + " is empty.");
        }

        for (String key: PROPS_NAMES) {

            String value = config.getProperty(key);

            if (value == null) {
                throw new RuntimeException(String.format("The key=%s in %s is missing.", key , PROP_FILE));
            }
        }

        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    public static Config getInstance(ServletContext context) {
        return (Config) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
