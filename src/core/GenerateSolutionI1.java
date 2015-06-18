package core;


import util.UnionFind;
import java.util.ArrayList;
import java.util.Collections;
import util.Edge;
import util.Graph;
import util.Vertex;
import util.VertexNotConnectedException;

public class GenerateSolutionI1 implements GenerateSolution {

    @Override
    public Graph generateInitialSolution(Graph graph) throws VertexNotConnectedException {
        ArrayList<Edge> EdgesOrdained; //conjunto de arestas do grafo ordenadas por valor
        //cria os makeSets
        for (Vertex v : graph.getVertices()) {
            v.setDisjointSet(UnionFind.makeSet(v));
        }

        EdgesOrdained = new ArrayList<>(graph.getEdges());
        Collections.sort(EdgesOrdained);

        Graph solution = new Graph();

        for (Vertex v : graph.getVertices()) {
            solution.addVertex(v);
        }

        for (Edge e1 : EdgesOrdained) {
            UnionFind<Vertex> u = e1.getSource().getDisjointSet();
            UnionFind<Vertex> v = e1.getTarget().getDisjointSet();

            if (!UnionFind.areUnited(u, v)) {
                u.union(v);
                solution.addEdge(e1.getSource(), e1.getTarget(), e1.getValue());
            }
        }

        return solution;
    }
}
