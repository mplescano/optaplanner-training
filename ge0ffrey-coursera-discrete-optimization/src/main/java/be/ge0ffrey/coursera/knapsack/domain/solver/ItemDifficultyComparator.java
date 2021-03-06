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

package be.ge0ffrey.coursera.knapsack.domain.solver;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import be.ge0ffrey.coursera.knapsack.domain.Item;


public class ItemDifficultyComparator implements Comparator<Item>, Serializable {

    public int compare(Item a, Item b) {
        return new CompareToBuilder()
                .append(a.getValuePerWeight(), b.getValuePerWeight())
                .append(a.getWeight(), b.getWeight())
                .append(a.getId(), b.getId())
                .toComparison();
    }

}
