package core.utils;

import core.constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/test/java/core/constants/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getUrl() {
        return Constants.url;
    }

    public String getBrowser() {
        return Constants.browser;
    }

    public int getImplicitWait() {
        return Constants.implicit_wait;
    }

    public String getTimeUnit() {
        return Constants.time_unit;
    }

    public String getCredentialsPath() {
        return Constants.credentials_path;
    }
}
