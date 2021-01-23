package me.doflamingo.springbootwebmvc.event;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NameValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(Event.class);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Event event = (Event) target;
    if(event.getName().equalsIgnoreCase("aaa")){
      errors.rejectValue("name","wrongValue","the value is wrong");
    }
  }
}
