package me.doflamingo.springbootwebmvc.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events")
  public String getList(Model model) {
    model.addAttribute("events", eventService.getList());
    return "events/list";
  }
}
