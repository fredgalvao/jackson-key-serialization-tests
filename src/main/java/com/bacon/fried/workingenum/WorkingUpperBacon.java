package com.bacon.fried.workingenum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class WorkingUpperBacon {

  @JsonProperty("m")
  public Map<WorkingBacon, WorkingBacon> m;

  public WorkingUpperBacon() {

  }

  public WorkingUpperBacon(Map<WorkingBacon, WorkingBacon> m) {
    this.m = m;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkingUpperBacon that = (WorkingUpperBacon) o;
    return m.equals(that.m);
  }

  @Override
  public int hashCode() {
    return Objects.hash(m);
  }
}
