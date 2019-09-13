package com.bacon.fried.workingdata;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class WorkingBacon2 {

  @JsonValue
  String x;

  public WorkingBacon2(String x) {
    this.x = x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkingBacon2 that = (WorkingBacon2) o;
    return x.equals(that.x);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x);
  }
}

