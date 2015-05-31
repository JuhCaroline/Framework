package core;


import util.Edge;
import util.Graph;
import util.Vertex;

public class ConcreteRestriction extends Restrictions{

    @Override
    boolean restrictVertex(Vertex v) {
        return true;
    }

    @Override
    boolean restrictEdge(Edge e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean restrictGraph(Graph g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
