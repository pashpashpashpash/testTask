package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private final String rootPath = System.getProperty("user.dir") + "/src/test/resources/";
    private final String appConfigPath = rootPath + "config.properties";
    private final String testPropsPath = rootPath + "test.properties";
    private final String driversPath = rootPath + "drivers/";

    private Properties appProps = new Properties();
    private Properties testProps = new Properties();


    public PropertiesUtil() {
        try {
            appProps.load(new FileInputStream(appConfigPath));
            testProps.load(new FileInputStream(testPropsPath));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public Properties getAppProps() {
        return appProps;
    }

    public Properties getTestProps() {
        return testProps;
    }

    public String getDriversPath() {return driversPath;}

}