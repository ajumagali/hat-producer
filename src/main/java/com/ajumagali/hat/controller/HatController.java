package com.ajumagali.hat.controller;

import com.ajumagali.hat.model.Hat;
import com.ajumagali.hat.service.HatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class HatController {
  private final HatService hatService;

  @GetMapping("hat/{id}")
  public Hat findHatById(@PathVariable Long id) {
    final Hat hat = hatService.findHatById(id);

    if (hat == null) {
      throw new ResponseStatusException(NOT_FOUND, String.format("Hat with id {} not found", id));
    }

    return hat;
  }
}
