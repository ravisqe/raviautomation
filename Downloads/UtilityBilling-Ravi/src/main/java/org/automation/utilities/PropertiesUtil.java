package org.automation.utilities;
/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class PropertiesUtil {


    static Properties prop = new Properties();

    public static String getPropertyValue(String key) {
        //1. load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/main/java/org/automation/config/config.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //2. read data
        String value = prop.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: " + key + " in properties file.");
            } catch (Exception e) {
            }
        }

        return value;
    }
}