package com.bacon.fried.failingenum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class FailingBaconSerializer extends StdSerializer<FailingBacon> {

  public FailingBaconSerializer() {
    super((Class<FailingBacon>) null);
  }

  @Override
  public void serialize(FailingBacon value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(value.x);
  }
}
