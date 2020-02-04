package com.mplescano.app.poc.optaplanner.solver.score;

import org.junit.BeforeClass;

import com.mplescano.app.poc.optaplanner.domain.KnapsackSolution;

public class KnapsackUnitTest {

  static KnapsackSolution unsolvedKnapsackSolution;
  
  @BeforeClass
  public static void setUp() {
    unsolvedKnapsackSolution = new KnapsackSolution();
    
    unsolvedKnapsackSolution.getItemList();
    
  }
}
