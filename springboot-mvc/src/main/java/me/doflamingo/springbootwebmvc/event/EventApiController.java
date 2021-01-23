package me.doflamingo.springbootwebmvc.event;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApiController {

  @PostMapping
  public Event createEvent(HttpEntity<Event> request) {
    System.out.println(request.getHeaders().getContentType());
    //save
    return request.getBody();
  }
}
