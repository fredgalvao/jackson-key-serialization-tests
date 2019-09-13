package com.bacon.fried.failingdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class FailingBaconDeserializer2 extends StdDeserializer<FailingBacon2> {

  public FailingBaconDeserializer2() {
    super((Class<?>) null);
  }

  @Override
  public FailingBacon2 deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode tree = p.getCodec().readTree(p);
    String asText = tree.asText();
    return new FailingBacon2(asText);
  }
}
