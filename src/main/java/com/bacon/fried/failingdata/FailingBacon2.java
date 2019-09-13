package com.bacon.fried.failingdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonSerialize(using = FailingBaconSerializer2.class)
@JsonDeserialize(using = FailingBaconDeserializer2.class)
public class FailingBacon2 {
  String x;

  public FailingBacon2(String x) {
    this.x = x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FailingBacon2 that = (FailingBacon2) o;
    return x.equals(that.x);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x);
  }
}
