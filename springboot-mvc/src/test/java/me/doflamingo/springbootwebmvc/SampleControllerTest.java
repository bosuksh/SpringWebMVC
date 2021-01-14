package me.doflamingo.springbootwebmvc;

import me.doflamingo.springbootwebmvc.event.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EventService eventService;

  @Test
  public void helloWithPath() throws Exception {
    mockMvc.perform(get("/hello/name"))
      .andDo(print())
      .andExpect(content().string("Hello name"));
  }

  @Test
  public void helloWithParam() throws Exception {
    mockMvc.perform(get("/hello")
      .param("name", "name"))
      .andDo(print())
      .andExpect(content().string("Hello name"));
  }

}