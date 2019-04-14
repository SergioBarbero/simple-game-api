package com.awesome2048.score;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Repository
public class ExternalService {

    public static String readFieldFromGetRequest(String query, String name) throws IOException {
        if (name != null) {
            String json = new RestTemplate().getForObject(query, String.class);
            ObjectNode object = new ObjectMapper().readValue(json, ObjectNode.class);
            JsonNode node = object.get(name);
            return (node == null ? null : node.textValue());
        }
        return null;
    }
}
