package me.doflamingo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MediaTypeControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void mediaTypeTest() throws Exception {
    //given
    //when
    mockMvc.perform(get("/mediaType")
      .contentType(MediaType.APPLICATION_JSON))
    //then
      .andExpect(status().isOk());
  }

  @Test
  public void contentTypeFailTest() throws Exception {
    //given
    //when
    mockMvc.perform(get("/mediaType")
      .contentType(MediaType.APPLICATION_XML))
    //then
      .andExpect(status().isUnsupportedMediaType());
  }

  @Test
  public void acceptHeaderFailTest() throws Exception {
    //given

    //when
    mockMvc.perform(get("/mediaType")
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
    //then
      .andExpect(status().isNotAcceptable());
  }

}