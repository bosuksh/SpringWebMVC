package me.doflamingo.springbootwebmvc.event;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalController {
  @ExceptionHandler
  public String eventError(EventException exception, Model model) {
    model.addAttribute("message", "Event Error");
    return "error";
  }

  @InitBinder
  public void initEventBinder(WebDataBinder webDataBinder) {
    webDataBinder.setDisallowedFields("id");
    webDataBinder.addValidators(new NameValidator());
  }
  @ModelAttribute
  public void addModel(Model model) {
    model.addAttribute("categories", List.of("A","B","C","D"));
  }
}
