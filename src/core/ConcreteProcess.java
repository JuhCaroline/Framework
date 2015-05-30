package core;


import util.Edge;
import util.Graph;

public class ConcreteProcess extends Process{

    @Override
    public void improveSolution(Graph solution, Restrictions restriction) {
        for (Edge edge : solution.getEdges()) {
            for (Edge edge1 : solution.getEdges()) {
                if((!edge1.getSource().getId().equals(edge.getSource().getId())) || (!edge1.getTarget().getId().equals(edge.getTarget().getId()))) {
                    //Restringir a inserção de modo que a aresta inserida
                    //diminua o número de tipos de conectores usados.
                }
            }
        }
    }
}
