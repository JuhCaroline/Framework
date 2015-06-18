
package util;

import IO.Input;

public class ConcreteRepresent implements Represent{

    private Graph graph;
    
    @Override
    public void createRepresentation(Input in) throws VertexNotConnectedException {
        graph = new Graph();
        for (int i = 0; i < in.getConfig()[0]; i++) {
            Vertex c = new Vertex("v"+(i+1));
            graph.addVertex(c);
        }
        
        for (int i = 0; i < in.getConfig()[0]; i++) {
            for (int j = 0; j < in.getConfig()[0]; j++) {
                if(i < j) {
                    graph.addEdge(graph.getVertices().get(i), graph.getVertices().get(j), in.getData()[i][j]);
                }
            }
        }
    }

    @Override
    public Graph getGraph() {
        return graph;
    }
    
}
