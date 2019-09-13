package com.bacon.fried.failingdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class FailingUpperBacon2 {

//  @JsonSerialize(keyUsing = FailingBaconSerializer2.class)
  @JsonSerialize(keyUsing = CustomKeySerializer.class)
  @JsonProperty("m")
  public Map<FailingBacon2, FailingBacon2> m;

  public FailingUpperBacon2() {

  }

  public FailingUpperBacon2(Map<FailingBacon2, FailingBacon2> m) {
    this.m = m;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FailingUpperBacon2 that = (FailingUpperBacon2) o;
    return m.equals(that.m);
  }

  @Override
  public int hashCode() {
    return Objects.hash(m);
  }

  public static class CustomKeySerializer extends StdSerializer<FailingBacon2> {

    public CustomKeySerializer() {
      super((Class<FailingBacon2>) null);
    }

    @Override
    public void serialize(FailingBacon2 value, JsonGenerator g, SerializerProvider provider) throws IOException {
      g.writeFieldName(value.x);
    }
  }
}
