package me.doflamingo.springbootwebmvc.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Getter @Setter
public class Person {

  @Id @GeneratedValue
  private Long id;

  private String name;

}
