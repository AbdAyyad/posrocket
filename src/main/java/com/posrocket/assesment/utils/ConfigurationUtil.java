package com.posrocket.assesment.utils;

import com.posrocket.assesment.Constants;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class ConfigurationUtil {
    private static Properties properties;

    private ConfigurationUtil() {
    }

    static {
        try {
            properties = new Properties();
            properties.load(ConfigurationUtil.class.getClassLoader().getResourceAsStream(Constants.Configurations.FILE_NAME));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Nullable
    public static String getConfig(String key) {
        return properties.getProperty(key);
    }
}
