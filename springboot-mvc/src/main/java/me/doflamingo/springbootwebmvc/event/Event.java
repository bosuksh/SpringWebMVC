package me.doflamingo.springbootwebmvc.event;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
  private String name;
  private int limitOfEnrollment;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
}
