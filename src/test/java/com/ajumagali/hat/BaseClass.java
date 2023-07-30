package com.ajumagali.hat;

import com.ajumagali.hat.controller.HatController;
import com.ajumagali.hat.model.Hat;
import com.ajumagali.hat.service.HatService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = Application.class)
public abstract class BaseClass {
  @Autowired
  HatController hatController;
  @MockBean
  HatService hatService;
  @Mock
  WebTestClient webTestClient;

  @BeforeEach
  void setup() {
    RestAssuredMockMvc.standaloneSetup(hatController);
    when(hatService.findHatById(1L))
          .thenReturn(new Hat(1L, "Test Hat 1", 10L, "striped"));
    when(hatService.findHatById(2L))
          .thenReturn(new Hat(2L, "Test Hat 2", 7L, "green"));
  }
}
