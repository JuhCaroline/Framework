
package util;

public class Vertex {
    private String id;
    private int degree;
    private UnionFind<Vertex> disjointSet;

    public Vertex(String id) {
        this.id = id;
        this.degree = 0;
        this.disjointSet = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setDisjointSet(UnionFind<Vertex> disjointSet) {
        this.disjointSet = disjointSet;
    }

    public UnionFind<Vertex> getDisjointSet() {
        return this.disjointSet;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
