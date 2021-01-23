package me.doflamingo.springbootwebmvc.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class EventControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  EventService eventService;

  @Test
  public void eventTest() throws Exception {
    mockMvc.perform(get("/events"))
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void get_eventTest_with_one_character() throws Exception {
    mockMvc.perform(get("/events/1"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(get("/events/2"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(get("/events/3"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(get("/events/4"))
      .andDo(print())
      .andExpect(status().isOk())
    ;
  }

  @Test
  public void create_eventTest_with_contentType_and_acceptHeader() throws Exception {
    mockMvc.perform(post("/events")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void delete_eventTest_with_one_character() throws Exception {
    mockMvc.perform(delete("/events/1"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(delete("/events/2"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(delete("/events/3"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(delete("/events/4"))
      .andDo(print())
      .andExpect(status().isOk())
    ;
  }

  @Test
  public void update_eventTest_with_contentType_and_acceptHeader() throws Exception {
    mockMvc.perform(put("/events/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(put("/events/2")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(put("/events/3")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
    ;

    mockMvc.perform(put("/events/4")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
    ;
  }

  @Test
  public void getEvent() throws Exception {
    this.mockMvc.perform(get("/events/1"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1))
    ;
  }

  @Test
  public void getEvent_with_matrixVariable() throws Exception {
    this.mockMvc.perform(get("/events/1;name=sh"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.name").value("sh"))
    ;
  }

  @Test
  public void createEvent_with_parameter() throws Exception {
    this.mockMvc.perform(post("/events")
        .param("name", "hello"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name").value("hello"))
    ;

    this.mockMvc.perform(post("/event")
        .param("name", "hello")
        .param("limitOfEnrollment", "5"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.limitOfEnrollment").value("5"))
    ;
  }

  @Test
  public void eventFormTest() throws Exception {
    MockHttpServletRequest request = this.mockMvc.perform(get("/events/form"))
      .andDo(print())
      .andExpect(view().name("events/eventForm"))
      .andExpect(model().attributeExists("event"))
      .andExpect(request().sessionAttribute("event", notNullValue()))
      .andReturn().getRequest();
    Object event = Objects.requireNonNull(request.getSession()).getAttribute("event");
    System.out.println(event);
  }

  @Test
  public void bindingTest() throws Exception {
    this.mockMvc.perform(post("/events?name=hello")
      .param("limitOfEnrollment","hi"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(model().hasErrors())
    ;

    this.mockMvc.perform(post("/events")
      .param("name","hello")
      .param("limitOfEnrollment", "-10"))
      .andDo(print())
      .andExpect(status().isOk())
    ;

  }

  @Test
  public void getEventList() throws Exception {
    //given
    Event event = new Event();
    event.setName("spring");
    event.setLimitOfEnrollment(100);
    //when
    this.mockMvc.perform(get("/events/list")
      .sessionAttr("visitTime", LocalDateTime.now())
      .flashAttr("event",event))
    //then
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(model().attributeExists("categories"))
      .andExpect(xpath("//tr").nodeCount(2))
    ;
  }
}