package com.baeldung.optaplanner.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.baeldung.optaplanner.solver.CloudComputerStrengthComparator;
import com.baeldung.optaplanner.solver.CloudProcessDifficultyComparator;

/**
 * This class is particularly important. It is the class that is modified during
 * solving.
 * 
 * @author mplescano
 *
 */
@PlanningEntity(difficultyComparatorClass = CloudProcessDifficultyComparator.class)
public class ProgramProcess {

	protected Long id;

	private int requiredCpu;

	private int requiredMemory;

	private int requiredNetworkBandwidth;

	private CloudComputer computer;

	public int getRequiredCpu() {
		return requiredCpu;
	}

	public void setRequiredCpu(int requiredCpu) {
		this.requiredCpu = requiredCpu;
	}

	public int getRequiredMemory() {
		return requiredMemory;
	}

	public void setRequiredMemory(int requiredMemory) {
		this.requiredMemory = requiredMemory;
	}

	public int getRequiredNetworkBandwidth() {
		return requiredNetworkBandwidth;
	}

	public void setRequiredNetworkBandwidth(int requiredNetworkBandwidth) {
		this.requiredNetworkBandwidth = requiredNetworkBandwidth;
	}

	@PlanningVariable(valueRangeProviderRefs = "computerRange", strengthComparatorClass = CloudComputerStrengthComparator.class)
	public CloudComputer getComputer() {
		return computer;
	}

	public void setComputer(CloudComputer computer) {
		this.computer = computer;
	}

	@PlanningId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRequiredMultiplicand() {
		return requiredCpu * requiredMemory * requiredNetworkBandwidth;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("computer", this.computer).build();
	}

}
