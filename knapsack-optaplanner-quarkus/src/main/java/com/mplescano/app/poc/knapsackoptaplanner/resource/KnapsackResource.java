package com.mplescano.app.poc.knapsackoptaplanner.resource;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;

import com.mplescano.app.poc.knapsackoptaplanner.domain.PackingSolution;

@Path("/knapsack")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KnapsackResource {

    @Inject
    private SolverManager<PackingSolution, UUID> solverManager;

    @POST
    @Path("/solve")
    public PackingSolution solve(PackingSolution problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving
        SolverJob<PackingSolution, UUID> solverJob = solverManager.solve(problemId, problem);
        PackingSolution solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }
}