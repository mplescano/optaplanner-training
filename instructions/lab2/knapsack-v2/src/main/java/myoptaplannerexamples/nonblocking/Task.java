package myoptaplannerexamples.nonblocking;

import java.util.concurrent.Callable;

import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.solver.Solver;

public class Task<S> extends AbstractTask implements Callable<Solver> {

  private Solver solver;
  private S initialSolution;

  public Task(Solver solver, S initialSolution) {
    this.solver = solver;
    this.initialSolution = initialSolution;
  }

  @Override
  public Solver call() throws Exception {
    solver.solve(initialSolution);

    return solver;
  }

}
