package me.doflamingo.springbootwebmvc.event;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

  private Integer id;
  @NotBlank(message = "Name must not be blank.")
  private String name;
  @Min(value = 0, message = "Limit of Enrollment must be larger than 0.")
  private int limitOfEnrollment;
  @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
}
