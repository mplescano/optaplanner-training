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

package com.mplescano.app.poc.optaplanner.solver.move;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveIteratorFactory;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import com.mplescano.app.poc.optaplanner.domain.Item;
import com.mplescano.app.poc.optaplanner.domain.KnapsackSolution;

public class MultiItemInverseMoveIteratorFactory implements MoveIteratorFactory<KnapsackSolution> {

  @Override
  public long getSize(ScoreDirector<KnapsackSolution> scoreDirector) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<Move<KnapsackSolution>> createOriginalMoveIterator(ScoreDirector<KnapsackSolution> scoreDirector) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<Move<KnapsackSolution>> createRandomMoveIterator(ScoreDirector<KnapsackSolution> scoreDirector, Random workingRandom) {
    KnapsackSolution knapsack = (KnapsackSolution) scoreDirector.getWorkingSolution();
    int maxInverseCount = Math.min(20, knapsack.getCapacity() * 2 / 3);
    return new MultiItemMoveIterator(knapsack.getItemList(), maxInverseCount, workingRandom);
  }

  private class MultiItemMoveIterator implements Iterator<Move<KnapsackSolution>> {

    private final List<Item> itemList;
    private final int maxInverseCount;
    private final Random workingRandom;

    public MultiItemMoveIterator(List<Item> itemList, int maxInverseCount, Random workingRandom) {
      this.itemList = itemList;
      this.maxInverseCount = maxInverseCount;
      this.workingRandom = workingRandom;
    }

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Move<KnapsackSolution> next() {
      // TODO select x random items to add, focusing on high-value items,
      // y random items to remove, focusing on low-value items
      // and optionally then add/remove items to become feasible
      int inverseCount = workingRandom.nextInt(maxInverseCount) + 1;
      Set<Item> itemSet = new HashSet<Item>(inverseCount);
      for (int i = 0; i < inverseCount; i++) {
        Item item = itemList.get(workingRandom.nextInt(itemList.size()));
        itemSet.add(item);
      }
      return new MultiItemInverseMove(itemSet);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
