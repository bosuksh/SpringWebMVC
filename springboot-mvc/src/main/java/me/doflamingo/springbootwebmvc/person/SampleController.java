package me.doflamingo.springbootwebmvc.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @GetMapping("/hello/{id}")
  public String helloByPath(@PathVariable("id") Person person) {
    return "Hello " + person.getName();
  }

  @GetMapping("/hello")
  public String helloByParam(@RequestParam("id") Person person) {
    return "Hello " + person.getName();
  }
}
