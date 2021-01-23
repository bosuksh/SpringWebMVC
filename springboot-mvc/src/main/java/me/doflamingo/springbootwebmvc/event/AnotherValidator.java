package me.doflamingo.springbootwebmvc.event;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class AnotherValidator{

  public void validate(Event target, Errors errors) {
    if(target.getName().equalsIgnoreCase("bbb")) {
      errors.rejectValue("name", "wrongValue", "bbb can not use here.");
    }
  }
}
