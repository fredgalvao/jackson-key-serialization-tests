package com.bacon.fried.failingdata;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class FailingBaconSerializer2 extends StdSerializer<FailingBacon2> {

  public FailingBaconSerializer2() {
    super((Class<FailingBacon2>) null);
  }

  @Override
  public void serialize(FailingBacon2 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(value.x);
  }
}
