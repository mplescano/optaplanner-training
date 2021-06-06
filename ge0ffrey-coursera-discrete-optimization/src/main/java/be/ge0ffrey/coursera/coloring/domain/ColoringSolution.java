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

package be.ge0ffrey.coursera.coloring.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoftlong.HardMediumSoftLongScore;
import org.optaplanner.examples.common.domain.AbstractJaxbPersistable;
import org.optaplanner.persistence.jaxb.api.score.buildin.hardmediumsoftlong.HardMediumSoftLongScoreJaxbXmlAdapter;
import org.optaplanner.persistence.xstream.api.score.buildin.hardmediumsoft.HardMediumSoftScoreXStreamConverter;

@PlanningSolution
@XStreamAlias("ColoringSolution")
@XmlRootElement(name = "ColoringSolution")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "colorList", "nodeList", "edgeList", "score" })
public class ColoringSolution extends AbstractJaxbPersistable {

	private static final long serialVersionUID = -8462806439445939948L;

	private List<Color> colorList;
    
    private List<Node> nodeList;
    
    private List<Edge> edgeList;

    @XStreamConverter(HardMediumSoftScoreXStreamConverter.class)
    private HardMediumSoftLongScore score;

    @ValueRangeProvider(id = "colorRange")
	@XmlElementWrapper
	@XmlElement(name = "Color")
    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @PlanningEntityCollectionProperty
	@XmlElementWrapper
	@XmlElement(name = "Node")
    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

	@XmlElementWrapper
	@XmlElement(name = "Edge")
    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    @PlanningScore
    @XmlJavaTypeAdapter(HardMediumSoftLongScoreJaxbXmlAdapter.class)
    public HardMediumSoftLongScore getScore() {
        return score;
    }

    public void setScore(HardMediumSoftLongScore score) {
        this.score = score;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    @ProblemFactCollectionProperty
    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(colorList);
        facts.addAll(edgeList);
        // Do not add the planning entity's (processList) because that will be done automatically
        return facts;
    }

}
