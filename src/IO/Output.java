package IO;

import util.Graph;

public interface Output {
    void open(String path);
    void close();
    void write(Graph graph);
}
