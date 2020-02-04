package com.mplescano.app.poc.optaplanner.solver.score;

import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import com.mplescano.app.poc.optaplanner.domain.Item;
import com.mplescano.app.poc.optaplanner.domain.KnapsackSolution;

public class KnapsackEasyScoreCalculator implements EasyScoreCalculator<KnapsackSolution> {

  public HardMediumSoftScore calculateScore(KnapsackSolution knapsack) {
    int free = knapsack.getCapacity();
    int valueTotal = 0;
    for (Item item : knapsack.getItemList()) {
      if (item.getInside() != null) {
        if (item.getInside().booleanValue()) {
          free -= item.getWeight();
          valueTotal += item.getValue();
        }
      }
    }
    return HardMediumSoftScore.of(free >= 0 ? 0 : free, valueTotal, free);
  }

}
