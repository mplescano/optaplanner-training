package com.mplescano.app.poc.optaplanner.solver.score;

import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.impl.score.director.incremental.AbstractIncrementalScoreCalculator;

import com.mplescano.app.poc.optaplanner.domain.Item;
import com.mplescano.app.poc.optaplanner.domain.KnapsackSolution;

public class KnapsackIncrementalScoreCalculator extends AbstractIncrementalScoreCalculator<KnapsackSolution> {

  private int free;
  private int valueTotal;

  public void resetWorkingSolution(KnapsackSolution knapsack) {
    free = knapsack.getCapacity();
    valueTotal = 0;
    for (Item item : knapsack.getItemList()) {
      insert(item);
    }
  }

  public void beforeEntityAdded(Object entity) {
    // Do nothing
  }

  public void afterEntityAdded(Object entity) {
    insert((Item) entity);
  }

  public void beforeVariableChanged(Object entity, String variableName) {
    retract((Item) entity);
  }

  public void afterVariableChanged(Object entity, String variableName) {
    insert((Item) entity);
  }

  public void beforeEntityRemoved(Object entity) {
    retract((Item) entity);
  }

  public void afterEntityRemoved(Object entity) {
    // Do nothing
  }

  private void insert(Item item) {
    Boolean inside = item.getInside();
    if (inside != null) {
      if (inside.booleanValue()) {
        free -= item.getWeight();
        valueTotal += item.getValue();
      }
    }
  }

  private void retract(Item item) {
    Boolean inside = item.getInside();
    if (inside != null) {
      if (inside.booleanValue()) {
        free += item.getWeight();
        valueTotal -= item.getValue();
      }
    }
  }

  public HardMediumSoftScore calculateScore() {
    return HardMediumSoftScore.of(free >= 0 ? 0 : free, valueTotal, free);
  }

}
