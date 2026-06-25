package org.sonatatui.utils;

import org.sonatatui.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private PropertyUtils() {}

    private static final Properties properties = new Properties();
    //Storing the values of properties file in HashMap as it is like the key-value pair.
    private static Map<String,String> map = new HashMap<String,String>();

    static {
        try {
            FileInputStream fs = new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(fs);

            for(Map.Entry<Object,Object> entry: properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                map.put(key, value);
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(String key) {
        return map.get(key);
    }
}
