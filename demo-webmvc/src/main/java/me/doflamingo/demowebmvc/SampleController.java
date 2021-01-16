package me.doflamingo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    return "hello";
  }

  @RequestMapping(value = "/hi", method = {RequestMethod.GET, RequestMethod.PATCH})
  @ResponseBody
  public String hi() {
    return "hi";
  }
}
