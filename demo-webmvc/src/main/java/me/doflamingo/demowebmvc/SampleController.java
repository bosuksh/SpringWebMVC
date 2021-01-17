package me.doflamingo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

  @GetMapping("/hello")
  @ResponseBody
  public String hello() {
    return "hello";
  }

  @PostMapping("/hello")
  @ResponseBody
  public String hello2() {
    return "hello2";
  }

  @RequestMapping(value = "/hi", method = {RequestMethod.GET, RequestMethod.PATCH})
  @ResponseBody
  public String hi() {
    return "hi";
  }

  @GetMapping("/urlPattern?")
  @ResponseBody
  public String urlPattern1() {
    return "urlPattern";
  }

  @GetMapping("/urlPattern3/*")
  @ResponseBody
  public String urlPattern3() {
    return "urlPattern3";
  }

  @GetMapping("/urlPattern4/**")
  @ResponseBody
  public String urlPattern4() {
    return "urlPattern4";
  }

  @GetCustomAnnotationMapping
  @ResponseBody
  public String custom() {
    return "custom";
  }
}
