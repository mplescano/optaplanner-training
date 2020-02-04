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

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import com.mplescano.app.poc.optaplanner.domain.Item;
import com.mplescano.app.poc.optaplanner.domain.KnapsackSolution;

public class MultiItemInverseMove implements Move<KnapsackSolution> {

    private final Set<Item> itemSet;

    public MultiItemInverseMove(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<KnapsackSolution> scoreDirector) {
        return true;
    }

    private Move<KnapsackSolution> createUndoMove(ScoreDirector<KnapsackSolution> scoreDirector) {
        return new MultiItemInverseMove(itemSet);
    }

    @Override
    public Move<KnapsackSolution> doMove(ScoreDirector<KnapsackSolution> scoreDirector) {
        for (Item item : itemSet) {
            scoreDirector.beforeVariableChanged(item, "inside");
            item.setInside(!item.getInside().booleanValue());
            scoreDirector.afterVariableChanged(item, "inside");
        }
        return this.createUndoMove(scoreDirector);
    }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return itemSet;
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Arrays.asList(Boolean.TRUE, Boolean.FALSE);
    }

    @Override
    public String toString() {
        return itemSet.toString();
    }
}
