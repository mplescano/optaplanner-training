package com.baeldung.optaplanner.solver.score;

import java.util.HashSet;
import java.util.Set;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baeldung.optaplanner.domain.CourseScheduleSolution;
import com.baeldung.optaplanner.domain.Lecture;

public class ScoreCalculator implements EasyScoreCalculator<CourseScheduleSolution> {

	Logger logger = LoggerFactory.getLogger(ScoreCalculator.class);
	
	@Override
	public Score<HardSoftScore> calculateScore(CourseScheduleSolution courseSchedule) {
		int hardScore = 0;
		int softScore = 0;

		Set<String> occupiedRooms = new HashSet<>();
		for (Lecture lecture : courseSchedule.getLectureList()) {
			if (lecture.getPeriod() != null && lecture.getRoomNumber() != null) {
				String roomInUse = lecture.getPeriod().toString() + ":" + lecture.getRoomNumber().toString();
				if (occupiedRooms.contains(roomInUse)) {
					hardScore += -1;
				} else {
					occupiedRooms.add(roomInUse);
				}
			}
		}
		logger.debug("hardScore {} softScore {}", hardScore, softScore);
		return HardSoftScore.of(hardScore, softScore);
	}
}