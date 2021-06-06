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

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import org.optaplanner.core.api.domain.solution.cloner.DeepPlanningClone;
import org.optaplanner.examples.common.domain.AbstractJaxbPersistable;

@DeepPlanningClone
@XStreamAlias("Edge")
@XmlAccessorType(XmlAccessType.NONE)
public class Edge extends AbstractJaxbPersistable {

	private static final long serialVersionUID = 5697350285493272148L;

	private Node leftNode;
    
    private Node rightNode;

	@XmlIDREF
    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
        this.leftNode.getEdgeList().add(this);
    }

    @XmlIDREF
    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
        this.rightNode.getEdgeList().add(this);
    }
    // ************************************************************************
    // Complex methods
    // ************************************************************************

    @Override
    public String toString() {
        return leftNode + "-" + rightNode;
    }

    public Node getOtherNode(Node node) {
        if (node == leftNode) {
            return rightNode;
        } else if (node == rightNode) {
            return leftNode;
        } else {
            throw new IllegalArgumentException("The node (" + node
                    + ") is not leftNode (" + leftNode + ") or rightNode (" + rightNode + ").");
        }
    }

}
