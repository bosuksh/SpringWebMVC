package me.doflamingo.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MediaTypeController {

  @RequestMapping(value = "/mediaType"
    ,consumes = MediaType.APPLICATION_JSON_VALUE
    ,produces = MediaType.TEXT_PLAIN_VALUE
  )
  @ResponseBody
  public String mediaType() {
    return "mediaType";
  }
}
