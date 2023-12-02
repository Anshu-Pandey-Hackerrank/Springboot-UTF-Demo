package com.hackerrank.api.repository;

import com.hackerrank.api.model.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CovidRepository extends JpaRepository<Covid, Long> {

  List<Covid> findTop5ByOrderByActiveDesc();

  List<Covid> findTop5ByOrderByDeathDesc();

  List<Covid> findTop5ByOrderByRecoveredDesc();

  @Query(value = "select sum(active) from covid", nativeQuery = true)
  Long findSumByActive();

  @Query(value = "select sum(death) from covid", nativeQuery = true)
  Long findSumByDeath();

  @Query(value = "select sum(recovered) from covid", nativeQuery = true)
  Long findSumByRecovered();
}
