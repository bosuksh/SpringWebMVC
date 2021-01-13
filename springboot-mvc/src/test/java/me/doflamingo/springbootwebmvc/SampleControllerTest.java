package me.doflamingo.springbootwebmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class SampleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void helloWithPath() throws Exception {
    mockMvc.perform(get("/hello/name"))
      .andDo(print())
      .andExpect(content().string("hello name"));
  }

  @Test
  public void helloWithParam() throws Exception {
    mockMvc.perform(get("/hello")
      .param("name", "name"))
      .andDo(print())
      .andExpect(content().string("hello name"));
  }

}