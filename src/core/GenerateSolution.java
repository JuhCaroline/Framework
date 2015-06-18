package core;


import util.Graph;
import util.VertexNotConnectedException;

public interface GenerateSolution {
    Graph generateInitialSolution(Graph graph)  throws VertexNotConnectedException ;
}
