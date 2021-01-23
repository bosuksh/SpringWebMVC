package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApiController {

  @PostMapping
  public Event createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      bindingResult.getFieldErrors().forEach(System.out::println);
    }
    //save
    return event;
  }
}
