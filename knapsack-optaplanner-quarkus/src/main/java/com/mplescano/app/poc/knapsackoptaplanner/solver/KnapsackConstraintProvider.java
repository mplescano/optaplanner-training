package com.mplescano.app.poc.knapsackoptaplanner.solver;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintCollectors;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

import com.mplescano.app.poc.knapsackoptaplanner.domain.Bin;
import com.mplescano.app.poc.knapsackoptaplanner.domain.Item;

public class KnapsackConstraintProvider implements ConstraintProvider {

	@Override
	public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
		return new Constraint[] { maxWeigh(constraintFactory), maxValue(constraintFactory) };
	}

	private Constraint maxWeigh(ConstraintFactory constraintFactory) {
		return constraintFactory.from(Item.class)
				.filter(item -> item.getSelected().booleanValue())
				.groupBy(ConstraintCollectors.sum(item -> item.getWeight()))
				.join(Bin.class)
				.filter((totalWeigthItems, bin) -> totalWeigthItems > bin.getMaxWeight())
				.penalize("Max Weight",
						HardSoftScore.ONE_HARD, (totalWeigthItems, bin) -> totalWeigthItems - bin.getMaxWeight());
	}
	
	private Constraint maxValue(ConstraintFactory constraintFactory) {
		return constraintFactory.from(Item.class)
				.filter(item -> item.getSelected().booleanValue())
				.reward("Max Value", HardSoftScore.ONE_SOFT, Item::getValue);
	}
}
