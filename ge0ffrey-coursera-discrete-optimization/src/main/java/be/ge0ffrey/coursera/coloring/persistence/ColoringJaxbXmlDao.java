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

import be.ge0ffrey.coursera.coloring.domain.ColoringSolution;

import java.io.File;

import org.optaplanner.persistence.jaxb.impl.domain.solution.CustomJaxbSolutionFileIO;

public class ColoringJaxbXmlDao extends CustomJaxbSolutionFileIO<ColoringSolution> {

    public ColoringJaxbXmlDao() {
        super(ColoringSolution.class);
    }

	@Override
	public ColoringSolution read(File inputSolutionFile) {

		return super.read(inputSolutionFile);
	}

    
}
