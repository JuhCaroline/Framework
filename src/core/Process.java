package core;

import IO.Output;
import util.EdgeNotExistsException;
import util.Graph;
import util.Represent;
import util.StatisticI1;
import util.VertexNotConnectedException;

public abstract class Process {

    public void process(Represent represent, int maxSteps, Output out, Restrictions restriction, StatisticI1 statistic, GenerateSolution generateSolution)  throws VertexNotConnectedException, EdgeNotExistsException {
        Graph init = initialSolution(generateSolution, represent);

        Graph graph = represent.getGraph();
        
        updateStatistics(init, statistic);
        
        for (int steps = 0; steps < maxSteps; steps++) {
            improveSolution(init, graph, restriction);
            updateStatistics(init, statistic);
        }

        out.write(init);
    }

    Graph initialSolution(GenerateSolution generateSolution, Represent represent) throws VertexNotConnectedException {
        return generateSolution.generateInitialSolution(represent.getGraph());
    }

    public void updateStatistics(Graph solution, StatisticI1 statistic) {
        statistic.addSample(solution);
    }

    public abstract void improveSolution(Graph solution, Graph graph, Restrictions restriction) throws VertexNotConnectedException;
}
