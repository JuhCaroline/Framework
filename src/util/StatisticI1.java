package util;

import java.util.ArrayList;
import java.util.Collections;

public class StatisticI1 implements Statistic {
    private ArrayList<Graph> samples;
    private boolean ordained;

    public StatisticI1() {
        samples = new ArrayList<>();
        ordained = false;
    }
    
    @Override
    public void addSample(Graph g) {
        samples.add(g);
    }
    
    public int minimum() {
        if(ordained == false){
            Collections.sort(samples);
            ordained = true;
        }
        return samples.get(0).getCost();
    }
    
    public int maximum() {
        if(ordained == false){
            Collections.sort(samples);
            ordained = true;
        }
        return samples.get(samples.size()-1).getCost();
    }
    
    public int mean() {
        int mean = 0;
        for (Graph sample : samples) {
            mean += sample.getCost();
        }
        
        mean = mean / samples.size();
        
        return mean;
    }
    
    public int median() {
        if(ordained == false){
            Collections.sort(samples);
            ordained = true;
        }
        
        if(samples.size() % 2 != 0) {
            return samples.get(((samples.size()+1)/2)).getCost();
        } else {
            int m1 = samples.get((samples.size()/2)).getCost();
            int m2 = samples.get(((samples.size()/2) + 1)).getCost();
            return (m1 + m2)/2;
        }
    }
}