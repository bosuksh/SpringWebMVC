package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventApiController {

  @PostMapping
  @ResponseBody
  public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      bindingResult.getFieldErrors().forEach(System.out::println);
      return ResponseEntity.badRequest().build();
    }
    //save
    return ResponseEntity.ok(event);
  }
}
