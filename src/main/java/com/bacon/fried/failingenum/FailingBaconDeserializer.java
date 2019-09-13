package com.bacon.fried.failingenum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class FailingBaconDeserializer extends StdDeserializer<FailingBacon> {

  public FailingBaconDeserializer() {
    super((Class<?>) null);
  }

  @Override
  public FailingBacon deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode tree = p.getCodec().readTree(p);
    String asText = tree.asText();
    return FailingBacon.findByX(asText);
  }
}
