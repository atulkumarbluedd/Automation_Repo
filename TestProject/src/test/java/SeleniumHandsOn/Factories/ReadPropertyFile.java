package SeleniumHandsOn.Factories;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import SeleniumHandsOn.ConfigSource.constants;

public class ReadPropertyFile {
    private ReadPropertyFile() {
        // this is to restrict any class to create object
    }

    /**
     * Here we are using static block so that property file is loaded once into the
     * map and then test case can simply leverage this map to get the value. as
     * loading the property file takes time.
     */

    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fis = new FileInputStream(constants.getCONFIG_FILE_PATH());
            properties.load(fis);
            properties.forEach((key, value) -> CONFIGMAP.put(String.valueOf(key), String.valueOf(value).trim()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key)))
            throw new Exception(STR."property name \{key} is not found. Please check config.properties !! ");
        return CONFIGMAP.get(key);
    }
}
