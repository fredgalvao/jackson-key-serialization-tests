package com.bacon.fried.failingenum;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Arrays;

@JsonSerialize(using = FailingBaconSerializer.class)
@JsonDeserialize(using = FailingBaconDeserializer.class)
public enum FailingBacon {
  A("a"),
  B("b");

  String x;

  FailingBacon(String x) {
    this.x = x;
  }

  public static FailingBacon findByX(String x) {
    return Arrays.stream(values()).filter((it) -> it.x.equals(x)).findFirst().get();
  }
}
