package me.doflamingo.springbootwebmvc;

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
