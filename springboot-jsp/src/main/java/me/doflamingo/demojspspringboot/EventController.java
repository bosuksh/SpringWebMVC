package me.doflamingo.demojspspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

  @GetMapping("/events")
  public String getEvents(Model model){

    Event event1 = new Event();
    event1.setName("스터디 1");
    event1.setStartTime(LocalDateTime.of(2021,1,11,10,0));

    Event event2 = new Event();
    event2.setName("스터디 2");
    event2.setStartTime(LocalDateTime.of(2021,1,18,10,0));

    model.addAttribute("message", "Hello World");
    model.addAttribute("events", List.of(event1, event2));

    return "events/list";
  }
}
