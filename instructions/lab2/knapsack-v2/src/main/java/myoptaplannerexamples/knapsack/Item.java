package myoptaplannerexamples.knapsack;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PlanningEntity
public class Item implements Serializable {

  private static final long serialVersionUID = -2315471065492755789L;

  private int id;

  @NotNull
  @Min(0)
  private int mass = 5;

  @NotNull
  @Min(0)
  private int value = 5;

  private boolean accomodated;
  
  @PlanningId
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMass() {
    return mass;
  }

  public void setMass(int mass) {
    this.mass = mass;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @PlanningVariable(valueRangeProviderRefs = { "accomodatedRange" })
  public boolean isAccomodated() {
    return accomodated;
  }

  public void setAccomodated(boolean accomodated) {
    this.accomodated = accomodated;
  }
}
