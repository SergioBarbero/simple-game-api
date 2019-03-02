package com.awesome2048.score;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ScoreSerializer extends StdSerializer<Score> {

    public ScoreSerializer() {
        this(null);
    }

    public ScoreSerializer(Class<Score> t) {
        super(t);
    }

    @Override
    public void serialize(Score score, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", score.getName());
        jsonGenerator.writeNumberField("score", score.getScore());
        jsonGenerator.writeStringField("countryCode", score.getCountryCode());
        jsonGenerator.writeEndObject();
    }
}
