package com.ajumagali.hat.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Hat {
  private Long id;
  private String name;
  private Long size;
  private String color;
}
