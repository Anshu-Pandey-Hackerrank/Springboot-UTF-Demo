package com.hackerrank.api.controller;

import com.hackerrank.api.model.Covid;
import com.hackerrank.api.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {
  private final CovidService covidService;

  @Autowired
  public CovidController(CovidService covidService) {
    this.covidService = covidService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Covid> getAllCovid() {
    return covidService.getAllCovid();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Covid createCovid(@RequestBody Covid covid) {
    return covidService.createNewCovid(covid);
  }
}
