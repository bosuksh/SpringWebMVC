package me.doflamingo.springbootwebmvc.event;

import org.h2.engine.Mode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {

  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events") public String getList(Model model) {
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
  public String creatEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "events/eventForm";
    }
    return "redirect:events/list";
  }

  @PostMapping("/event")
  @ResponseBody
  public Event creatEventWitParam(@RequestParam Map<String, String> map) {
    Event event = new Event();
    event.setName(map.get("name"));
    event.setLimitOfEnrollment(Integer.parseInt(map.get("limitOfEnrollment")));
    return event;
  }

  @GetMapping("/events/form")
  public String eventsForm(Model model) {
    Event event = new Event();
    event.setLimitOfEnrollment(10);
    model.addAttribute("event", event);
    return "events/eventForm";
  }

  @GetMapping("/events/list")
  public String getEventList(Model model) {

    Event event = new Event();
    event.setName("spring");
    event.setLimitOfEnrollment(10);
    List<Event> eventList = new ArrayList<>();
    eventList.add(event);

    model.addAttribute("eventList", eventList);
    return "events/list";
  }

}
