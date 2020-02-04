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

package be.ge0ffrey.coursera.vrp.persistence;

import java.io.IOException;

import org.optaplanner.core.impl.solution.Solution;
import org.optaplanner.examples.common.persistence.AbstractTxtSolutionExporter;
import org.optaplanner.examples.vehiclerouting.domain.Customer;
import org.optaplanner.examples.vehiclerouting.domain.Standstill;
import org.optaplanner.examples.vehiclerouting.domain.Vehicle;
import org.optaplanner.examples.vehiclerouting.domain.VehicleRoutingSolution;

public class CourseraVrpExporter extends AbstractTxtSolutionExporter {

    private static final String OUTPUT_FILE_SUFFIX = "txt";

    public static void main(String[] args) {
        new CourseraVrpExporter().convertAll();
    }

    public CourseraVrpExporter() {
        super(new CourseraVrpDao());
    }

    @Override
    public String getOutputFileSuffix() {
        return OUTPUT_FILE_SUFFIX;
    }

    public TxtOutputBuilder createTxtOutputBuilder() {
        return new CourseraVrpOutputBuilder();
    }

    public static class CourseraVrpOutputBuilder extends TxtOutputBuilder {

        private VehicleRoutingSolution solution;

        public void setSolution(Solution solution) {
            this.solution = (VehicleRoutingSolution) solution;
        }

        public void writeSolution() throws IOException {
            bufferedWriter.write((- solution.getScore().getSoftScore() / 1000L) + " 0\n");
            for (Vehicle vehicle : solution.getVehicleList()) {
                Standstill standstill = vehicle;
                while (standstill != null) {
                    bufferedWriter.write(standstill.getLocation().getId() + " ");
                    standstill = standstill.getNextCustomer();
                }
                bufferedWriter.write(vehicle.getLocation().getId() + "\n");
            }
        }
    }

}
