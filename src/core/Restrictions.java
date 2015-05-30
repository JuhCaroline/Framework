package core;


import util.Edge;
import util.Graph;
import util.Vertex;

public abstract class Restrictions {
    abstract boolean restrictVertex(Vertex v);
    abstract boolean restrictEdge(Edge e);
    abstract boolean restrictGraph(Graph g);
    boolean restrict(Vertex v, Edge e, Graph g) {
        return restrictEdge(e) && restrictVertex(v) && restrictGraph(g);
    }
}