package com.hackerrank.api.controller;

import com.hackerrank.api.exception.BadRequestException;
import com.hackerrank.api.model.Covid;
import com.hackerrank.api.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Covid getCovidById(@PathVariable Long id) {
    return covidService.getCovidById(id);
  }

  @GetMapping("/top5")
  @ResponseStatus(HttpStatus.OK)
  public List<Covid> top5(@RequestParam String by) {
    if ("active,death,recovered".contains(by)) {
      return covidService.top5By(by);
    } else {
      throw new BadRequestException("by option not supported: " + by);
    }
  }

  @GetMapping("/total")
  @ResponseStatus(HttpStatus.OK)
  public Integer totalBy(@RequestParam String by) {
    if ("active,death,recovered".contains(by)) {
      return covidService.totalBy(by);
    } else {
      throw new BadRequestException("by option not supported: " + by);
    }
  }
}
