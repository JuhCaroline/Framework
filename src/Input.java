package IO;

public interface Input {
    void open(String path);
    void close();
    void read();
    int[] getConfig(); 
    public int[][] getData();
}
