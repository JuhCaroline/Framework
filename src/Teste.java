
package util;

public class Teste {
    public static void main(String[] args) {
        Vertex v0 = new Vertex("V0");
        Vertex v1 = new Vertex("V1");
        
        Edge e0 = new Edge(v0, v1, 45);
        
        Graph g = new Graph();
        
        g.addVertex(v0);
        g.addVertex(v1);
        g.addEdge(e0.getSource(), e0.getTarget(), e0.getValue());
        
        System.out.println(g.toString());
    }
}
