package com.awesome2048.score;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class ExternalService {
    public static String readField(String json, String name) throws IOException {
        if (name != null) {
            ObjectNode object = new ObjectMapper().readValue(json, ObjectNode.class);
            JsonNode node = object.get(name);
            return (node == null ? null : node.textValue());
        }
        return null;
    }
}
