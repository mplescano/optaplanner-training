package com.baeldung.optaplanner.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * This class is particularly important. It is the class that is modified during
 * solving.
 * 
 * @author mplescano
 *
 */
@PlanningEntity
public class ProgramProcess {

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

	@PlanningVariable(valueRangeProviderRefs = "computerRange")
	public CloudComputer getComputer() {
		return computer;
	}

	public void setComputer(CloudComputer computer) {
		this.computer = computer;
	}

}
