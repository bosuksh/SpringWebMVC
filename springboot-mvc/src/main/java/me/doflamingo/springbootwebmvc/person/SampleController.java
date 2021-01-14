package me.doflamingo.springbootwebmvc.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
