package me.doflamingo.springbootwebmvc.event;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
  interface ValidateName{}
  interface ValidateNumber{}
  private Integer id;
  @NotBlank(groups = ValidateName.class)
  private String name;
  @Min(value = 0,groups = ValidateNumber.class)
  private int limitOfEnrollment;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
}
