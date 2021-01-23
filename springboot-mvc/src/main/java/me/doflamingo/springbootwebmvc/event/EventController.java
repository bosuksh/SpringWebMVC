package me.doflamingo.springbootwebmvc.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
@RequiredArgsConstructor
public class EventController {

  private final EventService eventService;
  private final AnotherValidator anotherValidator;

  @InitBinder
  public void initEventBinder(WebDataBinder webDataBinder) {
    webDataBinder.setDisallowedFields("id");
    webDataBinder.addValidators(new NameValidator());
  }
  @ModelAttribute
  public void addModel(Model model) {
    model.addAttribute("categories", List.of("A","B","C","D"));
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
  public String creatEventName(@Valid @ModelAttribute Event event,
                           BindingResult bindingResult){
    anotherValidator.validate(event, bindingResult);
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
                                BindingResult bindingResult,
                                SessionStatus sessionStatus,
                                RedirectAttributes redirectAttributes){
    if(bindingResult.hasErrors()) {
      return "events/eventForm-limit";
    }
    sessionStatus.setComplete();
    redirectAttributes.addFlashAttribute("event", event);
    return "redirect:/events/list";
  }

  @GetMapping("/events/form/limit")
  public String eventsFormList(@ModelAttribute Event event, Model model) {
    model.addAttribute("event", event);
    return "events/eventForm-limit";
  }

  @GetMapping("/events/list")
  public String getEventList(Model model,
                             @ModelAttribute Event newEvent,
                             @SessionAttribute("visitTime") LocalDateTime visitTime) {
    System.out.println(visitTime);
    List<Event> eventList = new ArrayList<>();
    eventList.add(newEvent);
    model.addAttribute("eventList", eventList);
    return "events/list";
  }

}
