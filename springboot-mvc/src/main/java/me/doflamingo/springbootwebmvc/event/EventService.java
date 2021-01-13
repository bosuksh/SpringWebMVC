package me.doflamingo.springbootwebmvc.event;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
  public List<Event> getList() {
    Event event1 = Event.builder()
          .name("스터디 1차")
          .limitOfEnrollment(5)
          .startDateTime(LocalDateTime.of(2020,1,1,10,0))
          .endDateTime(LocalDateTime.of(2020,1,1,12,0))
          .build();
    Event event2 = Event.builder()
      .name("스터디 2차")
      .limitOfEnrollment(5)
      .startDateTime(LocalDateTime.of(2020,1,8,10,0))
      .endDateTime(LocalDateTime.of(2020,1,8,12,0))
      .build();
    return List.of(event1,event2);
  }

}
