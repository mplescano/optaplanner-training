package com.baeldung.optaplanner.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class CloudBalanceSolution {

	private Long id;
	
	private List<CloudComputer> computerList;

	private List<ProgramProcess> processList;

	private HardSoftScore score;

	public CloudBalanceSolution() {
	}

	@ValueRangeProvider(id = "computerRange")
	@ProblemFactCollectionProperty
	public List<CloudComputer> getComputerList() {
		return computerList;
	}

	public void setComputerList(List<CloudComputer> computerList) {
		this.computerList = computerList;
	}

	@PlanningEntityCollectionProperty
	public List<ProgramProcess> getProcessList() {
		return processList;
	}

	public void setProcessList(List<ProgramProcess> processList) {
		this.processList = processList;
	}

	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	@PlanningId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("computerList", this.computerList)
				.append("processList", this.processList).build();
	}
	
	

	
}
