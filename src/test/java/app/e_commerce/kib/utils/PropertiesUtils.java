package app.e_commerce.kib.utils;
import java.io.*;
import java.util.Properties;
public class PropertiesUtils {


    public Properties loadProperties(String filePath) {

        try {
            File file =new File(filePath);
            InputStream fileInputStream = new FileInputStream(file);
            Properties properties =new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("file is not found");
        }
        catch (IOException e) {
            throw new RuntimeException("Error while loading properties");
        }
    }
}
