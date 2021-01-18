package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/event")
  public String getList(Model model) {
    model.addAttribute("events", eventService.getList());
    return "events/list";
  }

  @GetMapping("/events")
  @ResponseBody
  public String getEvents(){
    return "events";
  }

  @RequestMapping(value = "/events/?", method = {RequestMethod.GET, RequestMethod.DELETE})
  @ResponseBody
  public String getEventsWithOneCharacter(){
    return "events";
  }

  @PostMapping(
    value = "/events",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String postEventsWithJson() {
    return "/events";
  }

  @PutMapping(
    value = "/events/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String putEventsWithJson(@PathVariable Long id) {
    return "/events "+ id;
  }
}
