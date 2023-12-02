package com.hackerrank.api.service.impl;

import com.hackerrank.api.exception.BadRequestException;
import com.hackerrank.api.exception.ElementNotFoundException;
import com.hackerrank.api.model.Covid;
import com.hackerrank.api.repository.CovidRepository;
import com.hackerrank.api.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultCovidService implements CovidService {
  private final CovidRepository covidRepository;

  @Autowired
  DefaultCovidService(CovidRepository covidRepository) {
    this.covidRepository = covidRepository;
  }

  @Override
  public List<Covid> getAllCovid() {
    return covidRepository.findAll();
  }


  @Override
  public Covid createNewCovid(Covid covid) {
    if (covid.getId() != null) {
      throw new BadRequestException("The ID must not be provided when creating a new Covid");
    }

    return covidRepository.save(covid);
  }

  @Override
  public Covid getCovidById(Long id) {
    return covidRepository
            .findById(id)
            .orElseThrow(() -> new ElementNotFoundException("Covid with ID not found"));
  }

  @Override
  public List<Covid> top5By(String by) {
    switch (by) {
      case "active":
        return covidRepository.findTop5ByOrderByActiveDesc();
      case "death":
        return covidRepository.findTop5ByOrderByDeathDesc();
      case "recovered":
        return covidRepository.findTop5ByOrderByRecoveredDesc();
      default:
        throw new BadRequestException("invalid by");
    }
  }

  @Override
  public Integer totalBy(String by) {
    switch (by) {
      case "active":
        return covidRepository.findSumByActive().intValue();
      case "death":
        return covidRepository.findSumByDeath().intValue();
      case "recovered":
        return covidRepository.findSumByRecovered().intValue();
      default:
        throw new BadRequestException("invalid by");
    }
  }
}
