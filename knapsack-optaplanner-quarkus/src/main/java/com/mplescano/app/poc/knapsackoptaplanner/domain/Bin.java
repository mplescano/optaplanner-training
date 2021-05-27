package com.mplescano.app.poc.knapsackoptaplanner.domain;

public class Bin {

	private int maxWeight;

	public Bin() {
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "Bin [maxWeight=" + maxWeight + "]";
	}
	
	
}
