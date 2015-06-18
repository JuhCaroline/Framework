
package util;

import java.util.ArrayList;

public class Graph implements Comparable<Graph> {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private int maxDegree;
    private int cost;
    
    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.maxDegree = 0;
        this.cost = 0;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
    
    public void addVertex(Vertex u) {
        u.setDegree(0);
        this.vertices.add(u);
    }

    public void addEdge(Vertex u, Vertex v, int d) {
        u.setDegree(u.getDegree() + 1);
        v.setDegree(v.getDegree() + 1);
        
        this.edges.add(new Edge(u, v, d));

        if (u.getDegree() > this.maxDegree) {
            this.maxDegree = u.getDegree();
        }

        if (v.getDegree() > this.maxDegree) {
            this.maxDegree = v.getDegree();
        }

        this.cost += d;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaxDegree() {
        return this.maxDegree;
    }

    public void setMaxDegree(int maxDegree) {
        this.maxDegree = maxDegree;
    }

    @Override
    public String toString() {
        String s = "V = {";
        
        Vertex vtmp = this.vertices.get(this.vertices.size() - 1);
        this.vertices.remove(this.vertices.size() - 1);
        
        for (Vertex v : this.vertices) {
            s += v.toString() + ",";
        }
        
        this.vertices.add(vtmp);
        
        s += vtmp.toString() + "}";
        
        s += "; E = {";
        
        Edge etmp = this.edges.get(this.edges.size() - 1);
        this.edges.remove(this.edges.size() - 1);
        
        for (Edge e : this.edges) {
            s += e.toString() + ",";
        }
        
        this.edges.add(etmp);
        
        s += etmp.toString() + "}";
        
        return s;
    }
    
    public boolean hasCycle() throws VertexNotConnectedException {

        for (Vertex v : vertices) {
            v.setDisjointSet(UnionFind.makeSet(v));
        }

        for (Edge aresta1 : this.edges) {
            UnionFind<Vertex> v1 = aresta1.getSource().getDisjointSet();
            UnionFind<Vertex> v2 = aresta1.getTarget().getDisjointSet();

            if (!UnionFind.areUnited(v1, v2)) {
                v1.union(v2);
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public int compareTo(Graph t) {
        return Integer.compare(this.cost, t.getCost());
    }
}
