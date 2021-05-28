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

package be.ge0ffrey.coursera.faculty.app;

import be.ge0ffrey.coursera.faculty.persistence.FacultyPlacerDao;
import be.ge0ffrey.coursera.faculty.persistence.FacultyPlacerExporter;
import be.ge0ffrey.coursera.faculty.persistence.FacultyPlacerImporter;
import be.ge0ffrey.coursera.faculty.swingui.FacultyPlacerPanel;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.common.app.CommonApp;
import org.optaplanner.examples.common.persistence.AbstractSolutionExporter;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.common.swingui.SolutionPanel;
import org.optaplanner.persistence.common.api.domain.solution.SolutionFileIO;

public class FacultyPlacerApp extends CommonApp {

    public static final String SOLVER_CONFIG
            = "be/ge0ffrey/coursera/faculty/solver/facultyPlacerSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new FacultyPlacerApp().init();
    }

    public FacultyPlacerApp() {
        super("Faculty placer",
                "TODO",
                null, null, null);
    }

    protected Solver createSolver() {
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        return solverFactory.buildSolver();
    }

    @Override
    protected SolutionPanel createSolutionPanel() {
        return new FacultyPlacerPanel();
    }

    @Override
    protected AbstractSolutionImporter[] createSolutionImporters() {
        return new AbstractSolutionImporter[] {new FacultyPlacerImporter()};
    }

    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new FacultyPlacerExporter();
    }

	@Override
	public SolutionFileIO createSolutionFileIO() {
		// TODO Auto-generated method stub
		return null;
	}

}
