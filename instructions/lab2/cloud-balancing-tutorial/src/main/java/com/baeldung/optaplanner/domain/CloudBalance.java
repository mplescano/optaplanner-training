package com.baeldung.optaplanner.domain;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class CloudBalance {

	private List<CloudComputer> computerList;
	
	private List<ProgramProcess> processList;
	
	private HardSoftScore score;

	public CloudBalance() {
		this.computerList = new ArrayList<>();
		this.processList = new ArrayList<>();
	}

	@ValueRangeProvider(id = "computerRange")
	@ProblemFactCollectionProperty
	public List<CloudComputer> getComputerList() {
		return computerList;
	}

	@PlanningEntityCollectionProperty
	public List<ProgramProcess> getProcessList() {
		return processList;
	}

	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}
	
	
}
