package me.doflamingo.springbootwebmvc.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class EventApiControllerTest {

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  EventService eventService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void createEventTest() throws Exception {
    //given
    Event event = new Event();
    event.setId(1);
    event.setName("spring");
    event.setLimitOfEnrollment(100);

    String json = objectMapper.writeValueAsString(event);
    //when
    mockMvc.perform(post("/api/events")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
    //then
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("id").value(1))
      .andExpect(jsonPath("name").value("spring"))
      .andExpect(jsonPath("limitOfEnrollment").value(100));
  }

  @Test
  public void createEventWithInvalidValue() throws Exception {
    //given
    Event event = new Event();
    event.setId(1);
    event.setName("spring");
    event.setLimitOfEnrollment(-100);

    String json = objectMapper.writeValueAsString(event);
    //when
    mockMvc.perform(post("/api/events")
      .contentType(MediaType.APPLICATION_JSON)
      .content(json))
    //then
      .andDo(print())
      .andExpect(status().isBadRequest())
    ;

  }
}