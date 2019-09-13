package com.bacon;

import com.bacon.fried.failingdata.FailingBacon2;
import com.bacon.fried.failingdata.FailingUpperBacon2;
import com.bacon.fried.failingenum.FailingBacon;
import com.bacon.fried.failingenum.FailingUpperBacon;
import com.bacon.fried.workingdata.WorkingBacon2;
import com.bacon.fried.workingdata.WorkingUpperBacon2;
import com.bacon.fried.workingenum.WorkingBacon;
import com.bacon.fried.workingenum.WorkingUpperBacon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  private final FailingBacon failingBacon = FailingBacon.A;
  private final FailingBacon2 failingBacon2 = new FailingBacon2("a");
  private final WorkingBacon workingBacon = WorkingBacon.A;
  private final WorkingBacon2 workingBacon2 = new WorkingBacon2("a");

  private final String expectedSimpleJson = "\"a\"";
  private final String expectedSimpleMap = "{\"a\":\"b\"}";
  private final String expectedDtoMap = "{\"m\":{\"a\":\"b\"}}";

  private final Map<FailingBacon, FailingBacon> failingMap = new HashMap<>();
  private final Map<FailingBacon2, FailingBacon2> failingMap2 = new HashMap<>();
  private final Map<WorkingBacon, WorkingBacon> workingMap = new HashMap<>();
  private final Map<WorkingBacon2, WorkingBacon2> workingMap2 = new HashMap<>();


  {
    failingMap.put(failingBacon, FailingBacon.B);
    failingMap2.put(failingBacon2, new FailingBacon2("b"));
    workingMap.put(workingBacon, WorkingBacon.B);
    workingMap2.put(workingBacon2, new WorkingBacon2("b"));
  }

  private final FailingUpperBacon failingUpperBacon = new FailingUpperBacon(failingMap);
  private final FailingUpperBacon2 failingUpperBacon2 = new FailingUpperBacon2(failingMap2);
  private final WorkingUpperBacon workingUpperBacon = new WorkingUpperBacon(workingMap);
  private final WorkingUpperBacon2 workingUpperBacon2 = new WorkingUpperBacon2(workingMap2);

  @Test
  public void enum_serialize_A() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleJson, objectMapper.writeValueAsString(failingBacon));
  }

  @Test
  public void enum_deserialize_A() throws JsonProcessingException {
    Assert.assertEquals(failingBacon, objectMapper.readValue(expectedSimpleJson, FailingBacon.class));
  }

  @Test
  public void enum_serialize_B() throws JsonProcessingException {
    Assert.assertEquals(expectedDtoMap, objectMapper.writeValueAsString(failingUpperBacon));
  }

  @Test
  public void enum_deserialize_B() throws JsonProcessingException {
    Assert.assertEquals(failingUpperBacon, objectMapper.readValue(expectedDtoMap, new TypeReference<FailingUpperBacon>() {}));
  }

  @Test
  public void enum_serialize_inline() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleMap, objectMapper.writeValueAsString(failingMap));
  }

  @Test
  public void enum_deserialize_inline() throws JsonProcessingException {
    Assert.assertEquals(failingMap, objectMapper.readValue(expectedSimpleMap, new TypeReference<Map<FailingBacon, FailingBacon>>() {}));
  }

  @Test
  public void data_class_serialize_A() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleJson, objectMapper.writeValueAsString(failingBacon2));
  }

  @Test
  public void data_class_deserialize_A() throws JsonProcessingException {
    Assert.assertEquals(failingBacon2, objectMapper.readValue(expectedSimpleJson, FailingBacon2.class));
  }

  @Test
  public void data_class_serialize_B() throws JsonProcessingException {
    Assert.assertEquals(expectedDtoMap, objectMapper.writeValueAsString(failingUpperBacon2));
  }

  @Test
  public void data_class_deserialize_B() throws JsonProcessingException {
    Assert.assertEquals(failingUpperBacon2, objectMapper.readValue(expectedDtoMap, new TypeReference<FailingUpperBacon2>() {}));
  }

  @Test
  public void data_class_serialize_inline() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleMap, objectMapper.writeValueAsString(failingMap2));
  }

  @Test
  public void data_class_deserialize_inline() throws JsonProcessingException {
    Assert.assertEquals(failingMap2, objectMapper.readValue(expectedSimpleMap, new TypeReference<Map<FailingBacon2, FailingBacon2>>() {}));
  }

  @Test
  public void working_enum_serialize_A() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleJson, objectMapper.writeValueAsString(workingBacon));
  }

  @Test
  public void working_enum_deserialize_A() throws JsonProcessingException {
    Assert.assertEquals(workingBacon, objectMapper.readValue(expectedSimpleJson, WorkingBacon.class));
  }

  @Test
  public void working_enum_serialize_B() throws JsonProcessingException {
    Assert.assertEquals(expectedDtoMap, objectMapper.writeValueAsString(workingUpperBacon));
  }

  @Test
  public void working_enum_deserialize_B() throws JsonProcessingException {
    Assert.assertEquals(workingUpperBacon, objectMapper.readValue(expectedDtoMap, new TypeReference<WorkingUpperBacon>() {}));
  }

  @Test
  public void working_enum_serialize_inline() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleMap, objectMapper.writeValueAsString(workingMap));
  }

  @Test
  public void working_enum_deserialize_inline() throws JsonProcessingException {
    Assert.assertEquals(workingMap, objectMapper.readValue(expectedSimpleMap, new TypeReference<Map<WorkingBacon, WorkingBacon>>() {}));
  }

  @Test
  public void working_data_class_serialize_A() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleJson, objectMapper.writeValueAsString(workingBacon2));
  }

  @Test
  public void working_data_class_deserialize_A() throws JsonProcessingException {
    Assert.assertEquals(workingBacon2, objectMapper.readValue(expectedSimpleJson, WorkingBacon2.class));
  }

  @Test
  public void working_data_class_serialize_B() throws JsonProcessingException {
    Assert.assertEquals(expectedDtoMap, objectMapper.writeValueAsString(workingUpperBacon2));
  }

  @Test
  public void working_data_class_deserialize_B() throws JsonProcessingException {
    Assert.assertEquals(workingUpperBacon2, objectMapper.readValue(expectedDtoMap, new TypeReference<WorkingUpperBacon2>() {}));
  }

  @Test
  public void working_data_class_serialize_inline() throws JsonProcessingException {
    Assert.assertEquals(expectedSimpleMap, objectMapper.writeValueAsString(workingMap2));
  }

  @Test
  public void working_data_class_deserialize_inline() throws JsonProcessingException {
    Assert.assertEquals(workingMap2, objectMapper.readValue(expectedSimpleMap, new TypeReference<Map<WorkingBacon2, WorkingBacon2>>() {}));
  }
}
