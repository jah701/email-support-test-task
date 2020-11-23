package com.email.support.service.impl;

import com.email.support.service.PropertiesService;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesServiceImpl implements PropertiesService {
    private String rootPath
            = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private String appConfigPath = rootPath + "app.properties";

    @Override
    public String getProperty(String propName) {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException("Can't load properties from : " + appConfigPath, e);
        }
        return appProps.getProperty(propName);
    }
}
