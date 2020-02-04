/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mplescano.app.poc.optaplanner.domain;

import com.mplescano.app.poc.optaplanner.solver.ItemDifficultyComparator;

import java.io.Serializable;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = ItemDifficultyComparator.class)
public class Item implements Serializable {

  private static final long serialVersionUID = -3689317429583843521L;

  protected Long id;
  private int weight;
  private int value;

  // Planning variables: changes during planning, between score calculations.
  private Boolean inside;

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @PlanningVariable(valueRangeProviderRefs = { "insideRange" })
  public Boolean getInside() {
    return inside;
  }

  public void setInside(Boolean inside) {
    this.inside = inside;
  }

  // ************************************************************************
  // Complex methods
  // ************************************************************************

  public double getValuePerWeight() {
    return (double) value / (double) weight;
  }

  @Override
  public String toString() {
    return getClass().getName().replaceAll(".*\\.", "") + "-" + id + "@" + inside;
  }

  @PlanningId
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
