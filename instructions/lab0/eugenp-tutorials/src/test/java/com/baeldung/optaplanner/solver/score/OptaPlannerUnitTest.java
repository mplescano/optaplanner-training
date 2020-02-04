package com.baeldung.optaplanner.solver.score;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.baeldung.optaplanner.domain.CourseScheduleSolution;
import com.baeldung.optaplanner.domain.Lecture;

public class OptaPlannerUnitTest {

	static CourseScheduleSolution unsolvedCourseSchedule;

	@BeforeClass
	public static void setUp() {
		unsolvedCourseSchedule = new CourseScheduleSolution();

		for (int i = 0; i < 10; i++) {
			unsolvedCourseSchedule.getLectureList().add(new Lecture());
		}

		unsolvedCourseSchedule.getPeriodList().addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
		unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(new Integer[] { 1, 2 }));
	}

	@Test
	public void test_whenCustomJavaSolver() {
		SolverFactory<CourseScheduleSolution> solverFactory = SolverFactory
				.createFromXmlResource("courseScheduleSolverConfig.xml");
		Solver<CourseScheduleSolution> solverCourseSchedule = solverFactory.buildSolver();
		CourseScheduleSolution solvedCourseSchedule = solverCourseSchedule.solve(unsolvedCourseSchedule);

		Assert.assertNotNull("Score must not be null", solvedCourseSchedule.getScore());
		Assert.assertEquals("", -4, solvedCourseSchedule.getScore().getHardScore());
		solvedCourseSchedule.printCourseSchedule();
	}
}
