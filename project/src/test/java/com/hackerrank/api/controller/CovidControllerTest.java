package com.hackerrank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.api.model.Covid;
import com.hackerrank.api.repository.CovidRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
class CovidControllerTest {
  ObjectMapper om = new ObjectMapper();
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private CovidRepository repository;

  @Test
  public void testCreation() throws Exception {
    Covid expectedRecord = Covid.builder().country("Test Country").build();
    Covid actualRecord = om.readValue(mockMvc.perform(post("/covid")
                    .contentType("application/json")
                    .content(om.writeValueAsString(expectedRecord)))
            .andDo(print())
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Covid.class);

    Assertions.assertEquals(expectedRecord.getCountry(), actualRecord.getCountry());
  }

  @Test
  public void testCreation3() throws Exception {
    Covid expectedRecord = Covid.builder().country("Test Country3").build();
    Covid actualRecord = om.readValue(mockMvc.perform(post("/covid")
                    .contentType("application/json")
                    .content(om.writeValueAsString(expectedRecord)))
            .andDo(print())
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Covid.class);

    Assertions.assertEquals(expectedRecord.getCountry(), actualRecord.getCountry());
  }

  @Test
  public void testCreation1() throws Exception {
    Covid expectedRecord = Covid.builder().country("Test Country1").build();
    Covid actualRecord = om.readValue(mockMvc.perform(post("/covid")
                    .contentType("application/json")
                    .content(om.writeValueAsString(expectedRecord)))
            .andDo(print())
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Covid.class);

    Assertions.assertEquals(expectedRecord.getCountry(), actualRecord.getCountry());
  }

  @Test
  public void testCreation2() throws Exception {
    Covid expectedRecord = Covid.builder().country("Test Country2").build();
    Covid actualRecord = om.readValue(mockMvc.perform(post("/covid")
                    .contentType("application/json")
                    .content(om.writeValueAsString(expectedRecord)))
            .andDo(print())
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Covid.class);

    Assertions.assertEquals(expectedRecord.getCountry(), actualRecord.getCountry());
  }

}