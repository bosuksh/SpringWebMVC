package me.doflamingo.springbootwebmvc.person;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

  //핸들러 인터셉터
  /*
  * preHandle 1
  * preHandle 2
  * 요청 처리(Handler처리)
  * postHandler 2
  * postHandler 1
  * 뷰 랜더링
  * afterCompletion 2
  * afterCompletion 1
  * */


  @GetMapping("/hello/{id}")
  public String helloByPath(@PathVariable("id") Person person) {
    return "Hello " + person.getName();
  }

  @GetMapping("/hello")
  public String helloByParam(@RequestParam("id") Person person) {
    return "Hello " + person.getName();
  }

  @GetMapping("/message")
  public String message(@RequestBody String message) {
    return message;
  }
  @GetMapping("/jsonMessage")
  public Person jsonMessage(@RequestBody Person person) {
    return person;
  }
  @GetMapping("/mapMessage")
  public Map<String,String> mapMessage(@RequestBody HashMap<String, String> map) {
    System.out.println(map.toString());
    return map;
  }

  @GetMapping("/xmlMessage")
  public Person xmlMessage(@RequestBody Person person) {
    return person;
  }
}
