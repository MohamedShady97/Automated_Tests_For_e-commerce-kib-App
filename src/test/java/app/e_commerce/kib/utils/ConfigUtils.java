package app.e_commerce.kib.utils;
import java.util.Properties;

public class ConfigUtils {

    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {

        PropertiesUtils propertiesUtils = new PropertiesUtils();
        properties = propertiesUtils.loadProperties("src/test/java/app/e_commerce/kib/utils/TestData.Properties");

    }

    public static ConfigUtils getInstance(){
        if (configUtils==null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;

    }

    public String getBaseUrl() {

        String prop = properties.getProperty("baseUrl");
        if (prop != null)
            return prop;
        throw new RuntimeException("could not find the baseUrl");

    }
}
