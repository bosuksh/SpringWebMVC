package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
public class EventUpdateController {

  @PostMapping(value = "/events")
  @ResponseBody
  public String postEventsWithJson() {
    return "/events";
  }

  @PutMapping(value = "/events/{id}")
  @ResponseBody
  public String putEventsWithJson(@PathVariable Long id) {
    return "/events "+ id;
  }

}
