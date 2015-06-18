package util;

import IO.Input;

public interface Represent {
    void createRepresentation(Input in) throws VertexNotConnectedException ;
    Graph getGraph();
}
