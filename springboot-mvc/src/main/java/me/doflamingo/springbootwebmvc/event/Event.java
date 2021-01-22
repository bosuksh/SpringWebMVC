package me.doflamingo.springbootwebmvc.event;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
  private Integer id;
  private String name;
  @Min(0)
  private int limitOfEnrollment;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
}
