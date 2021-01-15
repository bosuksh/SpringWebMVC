package me.doflamingo.springbootwebmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.doflamingo.springbootwebmvc.event.EventService;
import me.doflamingo.springbootwebmvc.person.Person;
import me.doflamingo.springbootwebmvc.person.PersonRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EventService eventService;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private ObjectMapper objectMapper;

  private Long id;

  @BeforeEach
  public void setUp() {
    Person person = new Person();
    person.setName("name");
    Person savedPerson = personRepository.save(person);
    id =  savedPerson.getId();
  }

  @Test
  public void helloWithPath() throws Exception {
    mockMvc.perform(get("/hello/"+this.id))
      .andDo(print())
      .andExpect(content().string("Hello name"));
  }

  @Test
  public void helloWithParam() throws Exception {
    mockMvc.perform(get("/hello")
      .param("id", this.id.toString()))
      .andDo(print())
      .andExpect(content().string("Hello name"));
  }

  @Test
  public void helloStatic() throws Exception {
    mockMvc.perform(get("/index.html"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(Matchers.containsString("Hello Index")));
  }

  @Test
  public void resourceHandler() throws Exception {
    mockMvc.perform(get("/mobile/index.html"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(Matchers.containsString("Hello Mobile")))
      .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
  }

  @Test
  public void messageConverterTest() throws Exception {
    mockMvc.perform(get("/message")
      .content("hello"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("hello"));
  }

  @Test
  public void mapMessageConverterTest() throws Exception {
    mockMvc.perform(get("/mapMessage")
      .content("{\"command\":\"hello\"}")
      .contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void jsonMessage() throws Exception {
    Person person = new Person();
    person.setId(100L);
    person.setName("Doflamingo");
    String jsonString = objectMapper.writeValueAsString(person);
    mockMvc.perform(get("/jsonMessage")
      .content(jsonString)
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk());
  }

}