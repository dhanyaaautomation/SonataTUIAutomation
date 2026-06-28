package org.sonatatui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.sonatatui.pages.LoginPage;
import org.sonatatui.pojo.LoginData;

import java.io.File;

public class JsonUtils {

    private static final Logger logger = Log.getLogger(JsonUtils.class);

    public static LoginData getLoginData() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    new File(System.getProperty("user.dir")+"/src/test/resources/testdata/loginData.json"),
                    LoginData.class);

        } catch (Exception e) {
            logger.error("Unable to read JSON file", e);
            throw new RuntimeException("Unable to read JSON file", e);
        }
    }
}
