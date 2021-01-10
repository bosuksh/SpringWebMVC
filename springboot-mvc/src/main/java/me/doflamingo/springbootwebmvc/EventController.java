package me.doflamingo.springbootwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping("/events")
  public String getList(Model model) {
    model.addAttribute("events", eventService.getList());
    return "events/list";
  }
}
