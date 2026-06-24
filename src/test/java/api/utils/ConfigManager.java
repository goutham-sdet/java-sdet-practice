package api.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager
{
    private static final Properties props = new Properties();

    static
    {
        try (InputStream is = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config.properties"))
        {
            props.load(is);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key)
    {
        // allows override via -Dbase.url=https://staging...
        return System.getProperty(key, props.getProperty(key));
    }
}
