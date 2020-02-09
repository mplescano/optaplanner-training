package com.baeldung.optaplanner.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.optaplanner.core.api.domain.lookup.PlanningId;

public class CloudComputer {

	private Long id;
	
	private int cpu;

	private int memory;

	private int networkBandwidth;

	private int cost;

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getNetworkBandwidth() {
		return networkBandwidth;
	}

	public void setNetworkBandwidth(int networkBandwidth) {
		this.networkBandwidth = networkBandwidth;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@PlanningId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMultiplicand() {
		return cpu * memory * networkBandwidth;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).build();
	}
	
	
}
