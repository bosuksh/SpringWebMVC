package me.doflamingo.springbootwebmvc.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
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

  @PostMapping("/events/name")
  public String creatEventName(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult){
    if(bindingResult.hasErrors()) {
      return "events/eventForm-name";
    }
    return "redirect:/events/form/limit";
  }

  @GetMapping("/events/form/name")
  public String eventsFormName(Model model) {
    model.addAttribute("event", new Event());
    return "events/eventForm-name";
  }

  @PostMapping("/events/limit")
  public String creatEventLimit(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult){
    if(bindingResult.hasErrors()) {
      return "events/eventForm-limit";
    }
    return "redirect:/events/list";
  }

  @GetMapping("/events/form/limit")
  public String eventsFormList(@ModelAttribute Event event, Model model) {
    model.addAttribute("event", event);
    return "events/eventForm-limit";
  }

  @GetMapping("/events/list")
  public String getEventList(Model model, SessionStatus sessionStatus) {
    if(model.containsAttribute("event")) {
      Event event = (Event) model.getAttribute("event");
      List<Event> eventList = new ArrayList<>();
      eventList.add(event);
      sessionStatus.setComplete();
      model.addAttribute("eventList", eventList);
    }
    return "events/list";
  }

}
