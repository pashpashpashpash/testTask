package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    protected static final Logger logger = LogManager.getLogger();

    public static List<String> parseUsersEmails(Response response) {

        String responseBodyString = response.getBody().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<String> emails = new ArrayList<>();

        try {
            JsonNode node = mapper.readTree(responseBodyString).get("data");
            for (JsonNode userNode : node) {
                emails.add(userNode.get("email").textValue());

            }
        }
        catch (JsonProcessingException ex) {
            logger.error("Error occurred during response parsing");
            logger.error(ex.toString());
        }

        return emails;
    }
}
