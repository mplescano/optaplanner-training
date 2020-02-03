package com.baeldung.optaplanner.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Lecture {

	private Integer roomNumber;
	
	private Integer period;

	@PlanningVariable(valueRangeProviderRefs = "availableRooms")
	public Integer getRoomNumber() {
		return roomNumber;
	}

	@PlanningVariable(valueRangeProviderRefs = "availablePeriods")
	public Integer getPeriod() {
		return period;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	
}
