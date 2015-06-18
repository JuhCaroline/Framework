
package util;

public class Edge implements Comparable<Edge>{
    private Vertex source;
    private Vertex target;
    private int value;

    public Edge(Vertex source, Vertex target, int value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }
    
    public Vertex getSource() throws VertexNotConnectedException {
        if(source == null) {
            throw new VertexNotConnectedException("Vertice não existe.");
        }
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() throws VertexNotConnectedException {
        if(this.target == null) {
            throw new VertexNotConnectedException("Vertice não existe.");
        }
        return target;
    }

    public void setTarget(Vertex target){
        this.target = target;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + this.source + "," + this.target + "] = " + this.value;
    }

    @Override
    public int compareTo(Edge t) {
        return Integer.compare(this.value, t.getValue());
    }
}
