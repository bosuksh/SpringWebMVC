package me.doflamingo.springbootwebmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @GetMapping("/hello/{name}")
  public String helloByPath(@PathVariable("name") Person person) {
    return "Hello " + person.getName();
  }

  @GetMapping("/hello")
  public String helloByParam(@RequestParam("name") Person person) {
    return "Hello " + person.getName();
  }
}
