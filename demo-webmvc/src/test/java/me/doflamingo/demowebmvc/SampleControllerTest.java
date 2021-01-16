package me.doflamingo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void RequestMappingTest() throws Exception{
    this.mockMvc.perform(get("/hello"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(post("/hello"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(put("/hello"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(patch("/hello"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(delete("/hello"))
      .andDo(print())
      .andExpect(status().isOk());
  }


  @Test
  public void RequestMappingTest_GET_PATCH_ALLOW() throws Exception{
    this.mockMvc.perform(get("/hi"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(post("/hi"))
      .andDo(print())
      .andExpect(status().isMethodNotAllowed());

    this.mockMvc.perform(put("/hi"))
      .andDo(print())
      .andExpect(status().isMethodNotAllowed());

    this.mockMvc.perform(patch("/hi"))
      .andDo(print())
      .andExpect(status().isOk());

    this.mockMvc.perform(delete("/hi"))
      .andDo(print())
      .andExpect(status().isMethodNotAllowed());
  }
}