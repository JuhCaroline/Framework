package core;


import IO.Output;
import util.Graph;
import util.Represent;
import util.Statistic;

public abstract class Process {

    public void process(Represent represent, int maxSteps, Output out, Restrictions restriction, Statistic statistic, GenerateSolution generateSolution) {
        Graph init = initialSolution(generateSolution, represent);

        updateStatistics(init, statistic);
        
        for (int steps = 0; steps < maxSteps; steps++) {
            improveSolution(init, restriction);
            updateStatistics(init, statistic);
        }

        out.write(init);
    }

    Graph initialSolution(GenerateSolution generateSolution, Represent represent) {
        return generateSolution.generateInitialSolution(represent.getGraph());
    }

    public void updateStatistics(Graph solution, Statistic statistic) {
        statistic.addSample(solution);
    }

    public abstract void improveSolution(Graph solution, Restrictions restriction);
}
