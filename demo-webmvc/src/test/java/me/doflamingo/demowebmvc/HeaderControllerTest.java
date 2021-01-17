package me.doflamingo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HeaderControllerTest {

  @Autowired
  MockMvc mockMvc;


  @Test
  public void 헤더_존재_테스트() throws Exception {
    //given

    //when
    mockMvc.perform(get("/header1")
      .header(HttpHeaders.AGE,111))
    //then
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void 헤더_존재_안할때_테스트() throws Exception {
    //given

    //when
    mockMvc.perform(get("/header2")
      .header(HttpHeaders.AGE,111))
      //then
      .andDo(print())
      .andExpect(status().isNotFound());
  }

  @Test
  public void 헤더_일치_테스트() throws Exception {
    //given

    //when
    mockMvc.perform(get("/header3")
      .header(HttpHeaders.AUTHORIZATION,111))
      //then
      .andDo(print())
      .andExpect(status().isOk());

    //when
    mockMvc.perform(get("/header3")
      .header(HttpHeaders.AUTHORIZATION,222))
      //then
      .andDo(print())
      .andExpect(status().isNotFound());
  }

  @Test
  public void 파라미터_존재_테스트() throws Exception {
    //given

    //when
    mockMvc.perform(get("/param1")
      .param("name","111"))
      //then
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void 파라미터_일치_테스트() throws Exception {
    //given

    //when
    mockMvc.perform(get("/param2")
      .param("name","111"))
      //then
      .andDo(print())
      .andExpect(status().isOk());

    //when
    mockMvc.perform(get("/param2")
      .param("name","222"))
      //then
      .andDo(print())
      .andExpect(status().isBadRequest());
  }
}