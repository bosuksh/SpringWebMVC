package me.doflamingo.demojspspringboot;

import java.time.LocalDateTime;

public class Event {
  private String name;
  private LocalDateTime startTime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
}
