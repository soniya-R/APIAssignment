package org.automation.readPropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * reading properties file
 */

public class ReadPropertiesFile {

    public static Properties loadProperty(String filename) throws IOException {
        String path = System.getProperty("user.dir")+ "/resources/config.properties";
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        return prop;
    }
}
