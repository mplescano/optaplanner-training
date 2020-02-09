package com.baeldung.optaplanner.solver.score;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.baeldung.optaplanner.domain.CloudBalanceSolution;
import com.baeldung.optaplanner.domain.CloudComputer;
import com.baeldung.optaplanner.domain.ProgramProcess;

public class CloudBalancingUnitTest {

	@Test
	public void test_one() {
		List<CloudComputer> computerList = new ArrayList<>();
		CloudComputer cloudComputer = new CloudComputer();
		cloudComputer.setId(1L);
		cloudComputer.setCost(4800);
		cloudComputer.setCpu(24);
		cloudComputer.setMemory(96);
		cloudComputer.setNetworkBandwidth(16);
		computerList.add(cloudComputer);
		cloudComputer = new CloudComputer();
		cloudComputer.setId(2L);
		cloudComputer.setCost(660);
		cloudComputer.setCpu(6);
		cloudComputer.setMemory(4);
		cloudComputer.setNetworkBandwidth(6);
		computerList.add(cloudComputer);
		
		List<ProgramProcess> processList = new ArrayList<>();
		ProgramProcess cloudProcess = new ProgramProcess();
		cloudProcess.setId(3L);
		cloudProcess.setRequiredCpu(1);
		cloudProcess.setRequiredMemory(1);
		cloudProcess.setRequiredNetworkBandwidth(1);
		processList.add(cloudProcess);
		cloudProcess = new ProgramProcess();
		cloudProcess.setId(4L);
		cloudProcess.setRequiredCpu(3);
		cloudProcess.setRequiredMemory(6);
		cloudProcess.setRequiredNetworkBandwidth(1);
		processList.add(cloudProcess);
		cloudProcess = new ProgramProcess();
		cloudProcess.setId(5L);
		cloudProcess.setRequiredCpu(1);
		cloudProcess.setRequiredMemory(1);
		cloudProcess.setRequiredNetworkBandwidth(3);
		processList.add(cloudProcess);
		cloudProcess = new ProgramProcess();
		cloudProcess.setId(6L);
		cloudProcess.setRequiredCpu(1);
		cloudProcess.setRequiredMemory(2);
		cloudProcess.setRequiredNetworkBandwidth(11);
		processList.add(cloudProcess);
		cloudProcess = new ProgramProcess();
		cloudProcess.setId(7L);
		cloudProcess.setRequiredCpu(1);
		cloudProcess.setRequiredMemory(1);
		cloudProcess.setRequiredNetworkBandwidth(1);
		processList.add(cloudProcess);
		cloudProcess = new ProgramProcess();
		cloudProcess.setId(8L);
		cloudProcess.setRequiredCpu(1);
		cloudProcess.setRequiredMemory(1);
		cloudProcess.setRequiredNetworkBandwidth(5);
		processList.add(cloudProcess);
		
		CloudBalanceSolution unsolvedCloudBalanceSolution = new CloudBalanceSolution();
		unsolvedCloudBalanceSolution.setComputerList(computerList);
		unsolvedCloudBalanceSolution.setProcessList(processList);
		unsolvedCloudBalanceSolution.setId(9L);
		
	    SolverFactory<CloudBalanceSolution> solverFactory = SolverFactory.createFromXmlResource("org/optaplanner/examples/cloudbalancing/solver/cloudBalancingSolverConfig.xml");
	    Solver<CloudBalanceSolution> solverCourseSchedule = solverFactory.buildSolver();
	    CloudBalanceSolution solvedCloudBalanceSolution = solverCourseSchedule.solve(unsolvedCloudBalanceSolution);
	    System.out.println("Soluction: " + solvedCloudBalanceSolution);
	}
}
