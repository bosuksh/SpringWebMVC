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
}
