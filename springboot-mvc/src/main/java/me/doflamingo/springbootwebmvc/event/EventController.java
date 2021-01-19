package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

  @GetMapping("/events/{id}")
  @ResponseBody
  public Event getEvents(@PathVariable Integer id, @MatrixVariable(required = false) String name){
    Event event = new Event();
    event.setId(1);
    event.setName(name);
    return event;
  }

  @DeleteMapping("/events/{id}")
  @ResponseBody
  public String removeEvents(@PathVariable Integer id){
    return "event removed";
  }

  @PostMapping("/events")
  @ResponseBody
  public Event creatEvent(@RequestParam String name) {
    Event event = new Event();
    event.setName(name);
    return event;
  }

  @PostMapping("/event")
  @ResponseBody
  public Event creatEventWitParam(@RequestParam Map<String, String> map) {
    Event event = new Event();
    event.setName(map.get("name"));
    event.setLimitOfEnrollment(Integer.valueOf(map.get("limit")));
    return event;
  }

}
