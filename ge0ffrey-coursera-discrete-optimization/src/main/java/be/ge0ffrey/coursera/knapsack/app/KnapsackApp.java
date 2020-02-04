/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.ge0ffrey.coursera.knapsack.app;

import be.ge0ffrey.coursera.knapsack.persistence.KnapsackDao;
import be.ge0ffrey.coursera.knapsack.persistence.KnapsackExporter;
import be.ge0ffrey.coursera.knapsack.persistence.KnapsackImporter;
import be.ge0ffrey.coursera.knapsack.swingui.KnapsackPanel;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.common.app.CommonApp;
import org.optaplanner.examples.common.persistence.AbstractSolutionExporter;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.common.persistence.SolutionDao;
import org.optaplanner.examples.common.swingui.SolutionPanel;

public class KnapsackApp extends CommonApp {

    public static final String SOLVER_CONFIG
            = "be/ge0ffrey/coursera/knapsack/solver/knapsackSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new KnapsackApp().init();
    }

    public KnapsackApp() {
        super("Knapsack",
                "TODO",
                null, null);
    }

    @Override
    protected Solver createSolver() {
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        return solverFactory.buildSolver();
    }

    @Override
    protected SolutionPanel createSolutionPanel() {
        return new KnapsackPanel();
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new KnapsackDao();
    }

    @Override
    protected AbstractSolutionImporter[] createSolutionImporters() {
        return new AbstractSolutionImporter[] {new KnapsackImporter()};
    }

    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new KnapsackExporter();
    }

}
