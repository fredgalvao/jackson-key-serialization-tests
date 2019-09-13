package com.bacon.fried.workingenum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum WorkingBacon {
  A("a"),
  B("b");

  @JsonValue
  String x;

  WorkingBacon(String x) {
    this.x = x;
  }

  @JsonCreator
  public static WorkingBacon findByX(String x) {
    return Arrays.stream(values()).filter((it) -> it.x.equals(x)).findFirst().get();
  }
}
