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

package be.ge0ffrey.coursera.coloring.persistence;

import java.io.File;

import org.optaplanner.persistence.common.api.domain.solution.SolutionFileIO;

import be.ge0ffrey.coursera.coloring.domain.ColoringSolution;

public class ColoringProblemIO implements SolutionFileIO<ColoringSolution> {

    public static final String FILE_EXTENSION = "txt";

    private ColoringImporter importer = new ColoringImporter();
    private ColoringExporter exporter = new ColoringExporter();

    @Override
    public String getInputFileExtension() {
        return null;
    }

    @Override
    public String getOutputFileExtension() {
    	return FILE_EXTENSION;
    }

    @Override
    public ColoringSolution read(File inputSolutionFile) {
        return importer.readSolution(inputSolutionFile);
    }

    @Override
    public void write(ColoringSolution solution, File outputSolutionFile) {
        exporter.writeSolution((ColoringSolution) solution, outputSolutionFile);
    }

}