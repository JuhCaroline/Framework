/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.HashSet;
import javax.swing.JOptionPane;
import util.Edge;
import util.Graph;

/**
 *
 * @author thiag
 */
public class OutputMem implements Output{

    @Override
    public void open(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(Graph graph) {
        HashSet<Integer> coresInit = new HashSet<>();
        
        for (Edge e : graph.getEdges()) {
            coresInit.add(e.getValue());
        }
        
        String s = "Número de conexões: " + coresInit.size() + "\n Rede : " + graph.toString();
        JOptionPane.showMessageDialog(null, s);
    }
}
