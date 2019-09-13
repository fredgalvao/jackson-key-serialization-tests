package com.bacon.fried.workingdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class WorkingUpperBacon2 {

  @JsonProperty("m")
  public Map<WorkingBacon2, WorkingBacon2> m;

  public WorkingUpperBacon2() {

  }

  public WorkingUpperBacon2(Map<WorkingBacon2, WorkingBacon2> m) {
    this.m = m;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkingUpperBacon2 that = (WorkingUpperBacon2) o;
    return m.equals(that.m);
  }

  @Override
  public int hashCode() {
    return Objects.hash(m);
  }
}
