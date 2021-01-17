package me.doflamingo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

  @Test
  public void URI_PATTERN_ONE() throws Exception {
    this.mockMvc.perform(get("/urlPattern1"))
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void URI_PATTERN_TWO() throws Exception {
    this.mockMvc.perform(get("/urlPattern2/2"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("urlPattern2"))
    ;
  }

  @Test
  public void URI_PATTERN_THREE() throws Exception {
    this.mockMvc.perform(get("/urlPattern3/123"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("urlPattern3"))
    ;
    this.mockMvc.perform(get("/urlPattern3/123/hi"))
      .andDo(print())
      .andExpect(status().isNotFound())
    ;
  }

  @Test
  public void URI_PATTERN_FOUR() throws Exception {
    this.mockMvc.perform(get("/urlPattern4/123/hi"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("urlPattern4"))
    ;
  }

  @Test
  public void HEAD_TEST() throws Exception {
    //given

    //when
    this.mockMvc.perform(head("/hello"))
      .andDo(print())
    //then
      .andExpect(status().isOk())
      ;
  }

  @Test
  public void OPTIONS_TEST() throws Exception {
    //given

    //when
    this.mockMvc.perform(options("/hello"))
      .andDo(print())
    //then
      .andExpect(status().isOk())
      .andExpect(header().stringValues(HttpHeaders.ALLOW,
        hasItems(
          containsString("GET"),
          containsString("POST"),
          containsString("HEAD"),
          containsString("OPTIONS"))));
  }

}