package com.bacon.fried.failingenum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class FailingUpperBacon {

//  @JsonSerialize(keyUsing = FailingBaconSerializer.class)
  @JsonSerialize(keyUsing = CustomKeySerializer.class)
  @JsonProperty("m")
  public Map<FailingBacon, FailingBacon> m;

  public FailingUpperBacon() {

  }

  public FailingUpperBacon(Map<FailingBacon, FailingBacon> m) {
    this.m = m;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FailingUpperBacon that = (FailingUpperBacon) o;
    return m.equals(that.m);
  }

  @Override
  public int hashCode() {
    return Objects.hash(m);
  }

  public static class CustomKeySerializer extends StdSerializer<FailingBacon> {

    public CustomKeySerializer() {
      super((Class<FailingBacon>) null);
    }

    @Override
    public void serialize(FailingBacon value, JsonGenerator g, SerializerProvider provider) throws IOException {
      g.writeFieldName(value.x);
    }
  }
}
