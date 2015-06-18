package core;


import java.util.HashSet;
import util.Edge;
import util.Graph;
import util.VertexNotConnectedException;

public class ProcessI1 extends Process{

    HashSet<Integer> cores = new HashSet<>();
    
    @Override
    public void improveSolution(Graph solution, Graph graph, Restrictions restriction) throws VertexNotConnectedException {
        
        HashSet<Integer> coresInit = new HashSet<>();
        
        for (Edge e : solution.getEdges()) {
            coresInit.add(e.getValue());
        }
        
        for (Edge edge : solution.getEdges()) {
            for (Edge edge1 : graph.getEdges()) {
                
                //Restringir a inserção de modo que a aresta inserida
                //diminua o número de tipos de conectores usados.
                
                if((!edge1.getSource().getId().equals(edge.getSource().getId())) || (!edge1.getTarget().getId().equals(edge.getTarget().getId()))) {
                    Edge edgetemp = edge;
                    edge = edge1;
                    for (Edge e : solution.getEdges()) {
                        cores.add(e.getValue());
                    }
                    
                    if(coresInit.size() > cores.size()) {
                        cores.clear();
                        break;
                    } else {
                        
                        edge = edgetemp;
                    }
                    
                }
            }
        }
    }
}
