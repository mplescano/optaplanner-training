package myoptaplannerexamples.graphcoloring;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class GraphSolution {
	
	@PlanningEntityCollectionProperty
	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	@ProblemFactCollectionProperty
	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	@PlanningScore
	public HardSoftScore getScore() {
		return this.score;
	}

	public void setScore(HardSoftScore score) {
		this.score=score;
	}
	
	@ValueRangeProvider(id = "colorRange")
	public List<Integer> colorRange() {
		List<Integer> range=new ArrayList<Integer>();
		
		int maxColors=vertexList.size();
		for(int i=0;i<maxColors;i++) {
			range.add(i);
		}
		
		return range;
	}

	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	private HardSoftScore score=null;
}
