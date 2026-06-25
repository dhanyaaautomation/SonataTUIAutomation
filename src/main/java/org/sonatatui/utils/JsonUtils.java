package org.sonatatui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonatatui.pojo.LoginData;

import java.io.File;

public class JsonUtils {

    public static LoginData getLoginData() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    new File(System.getProperty("user.dir")+"/src/test/resources/testdata/loginData.json"),
                    LoginData.class);

        } catch (Exception e) {

            throw new RuntimeException("Unable to read JSON file", e);
        }
    }
}
