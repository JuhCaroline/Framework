/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Collections;
import util.Graph;
import util.Edge;
import util.UnionFind;
import util.Vertex;
import util.VertexNotConnectedException;

/**
 *
 * @author thiag
 */
public class ProcessI2 extends Process {

    @Override
    public void improveSolution(Graph solution, Graph graph, Restrictions restriction) throws VertexNotConnectedException {
        Vertex v1 = null, v2 = null;
        
        Collections.sort(graph.getEdges());
        
        boolean changed = false;
        
        do {
            changed = true;
            Collections.sort(solution.getEdges());
            int j = solution.getVertices().size() - 100;
            while (j >= 0) {
                int k = graph.getEdges().size();
                while(solution.getEdges().get(j).getValue() > graph.getEdges().get(k).getValue()) {
                    solution.hasCycle();
                    
                    for(Vertex v : solution.getVertices()) {
                        if(graph.getEdges().get(k).getSource().getId().equals(v.getId())) {
                            v1 = graph.getEdges().get(k).getSource();
                        }
                    }
                    
                    for(Vertex v : solution.getVertices()) {
                        if(graph.getEdges().get(k).getTarget().getId().equals(v.getId())) {
                            v2 = graph.getEdges().get(k).getTarget();
                        }
                    }
                    
                    UnionFind<Vertex> u = v1.getDisjointSet();
                    UnionFind<Vertex> v = v2.getDisjointSet();
                    
                    if (!UnionFind.areUnited(u, v)) {
                        if ((graph.getEdges().get(k).getSource().getDegree() + 1) <= 2 && (graph.getEdges().get(k).getTarget().getDegree() + 1) <= 2) {
                            u.union(v);
                            swap(solution, solution.getEdges().get(j), graph.getEdges().get(k));
                            changed = true;
                            break;
                        }
                    }
                    k = k - 1;
                }
                j = j - 1;
            } 
        } while (!changed);
    }
    
    private void swap(Graph T, Edge e1, Edge e2) throws VertexNotConnectedException {
        Vertex v1 = null,v2 = null;
        
        if(e1.getSource().getDegree() == T.getMaxDegree()) {
            int max = T.getMaxDegree();
            T.setMaxDegree(max--);
        } else if(e1.getTarget().getDegree() == T.getMaxDegree()) {
            int max = T.getMaxDegree();
            T.setMaxDegree(max--);
        }
        
        int degreeS = e1.getSource().getDegree();
        e1.getSource().setDegree(degreeS--);
        int degreeT = e1.getTarget().getDegree();
        e1.getTarget().setDegree(degreeT--);
        
        T.setCost(T.getCost() - e1.getValue());
        
        T.getEdges().remove(e1);
        
        for (Vertex v : T.getVertices()) {
            if(e2.getSource().getId().equals(v.getId())) {
                int degree = v.getDegree();
                v.setDegree(degree++);
                v1 = v;
                if (v.getDegree() > T.getMaxDegree()) {
                    T.setMaxDegree(v.getDegree());
                }
            }
        }
        
        for (Vertex v : T.getVertices()) {
            if(e2.getTarget().getId().equals(v.getId())) {
                int degree = v.getDegree();
                v.setDegree(degree++);
                v2 = v;
                if (v.getDegree() > T.getMaxDegree()) {
                    T.setMaxDegree(v.getDegree());
                }
            }
        }
        
        Edge e = new Edge(v1, v2, e2.getValue());
        
        T.getEdges().add(e);
    }
}
