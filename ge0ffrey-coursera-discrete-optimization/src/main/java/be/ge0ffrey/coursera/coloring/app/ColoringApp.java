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

package be.ge0ffrey.coursera.coloring.app;

import be.ge0ffrey.coursera.coloring.domain.ColoringSolution;
import be.ge0ffrey.coursera.coloring.persistence.ColoringXStreamDao;
import be.ge0ffrey.coursera.coloring.persistence.ColoringExporter;
import be.ge0ffrey.coursera.coloring.persistence.ColoringImporter;
import be.ge0ffrey.coursera.coloring.persistence.ColoringJaxbXmlDao;
import be.ge0ffrey.coursera.coloring.swingui.ColoringPanel;
import org.optaplanner.examples.common.app.CommonApp;
import org.optaplanner.examples.common.persistence.AbstractSolutionExporter;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.common.swingui.SolutionPanel;
import org.optaplanner.persistence.common.api.domain.solution.SolutionFileIO;

public class ColoringApp extends CommonApp<ColoringSolution> {

	public static final String DATA_DIR_NAME = "coloring";
	
    public static final String SOLVER_CONFIG
            = "be/ge0ffrey/coursera/coloring/solver/coloringSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new ColoringApp().init();
    }

    public ColoringApp() {
        super("Coloring",
                "TODO",
                SOLVER_CONFIG, DATA_DIR_NAME, null);
    }

    @Override
    protected SolutionPanel<ColoringSolution> createSolutionPanel() {
        return new ColoringPanel();
    }

    public SolutionFileIO<ColoringSolution> createSolutionFileIO() {
    	return new ColoringJaxbXmlDao();
    }

    @Override
    protected AbstractSolutionImporter[] createSolutionImporters() {
        return new AbstractSolutionImporter[]{new ColoringImporter()};
    }

    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new ColoringExporter();
    }

}
