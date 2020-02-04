package myoptaplannerexamples.knapsack;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class KnapsackSolution {

  private int capacity = 100;

  private List<Item> items;

  private HardSoftScore score = null;

  @PlanningScore
  public HardSoftScore getScore() {
    return this.score;
  }

  public void setScore(HardSoftScore score) {
    this.score = score;
  }

  @ProblemFactProperty
  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  @PlanningEntityCollectionProperty
  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @ValueRangeProvider(id = "accomodatedRange")
  public List<Boolean> getAccomodatedRange() {
    List<Boolean> accomodatedRange = new ArrayList<Boolean>();
    accomodatedRange.add(true);
    accomodatedRange.add(false);

    return accomodatedRange;
  }
}
