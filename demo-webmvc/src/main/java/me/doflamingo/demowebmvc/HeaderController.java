package me.doflamingo.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

  @GetMapping(value = "/header1", headers = HttpHeaders.AGE)
  @ResponseBody
  public String header1() {
    return "header1";
  }

  @GetMapping(value = "/header2", headers = "!"+HttpHeaders.AGE)
  @ResponseBody
  public String header2() {
    return "header2";
  }

  @GetMapping(value = "/header3", headers = HttpHeaders.AUTHORIZATION + "=111" )
  @ResponseBody
  public String header3() {
    return "header3";
  }


  @GetMapping(value = "/param1", params = "name" )
  @ResponseBody
  public String param1() {
    return "param1";
  }

  @GetMapping(value = "/param2", params = "name=111" )
  @ResponseBody
  public String param2() {
    return "param2";
  }
}
