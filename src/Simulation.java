import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private Renderer renderer;
    private List<Action> initActions;
    private List<Action> turnActions;
    private int turnCounter;
    private volatile boolean running;

    public int getTurnCounter() {
        return turnCounter;
    }

    public void startSimulationThread() {
        this.running = true;
    }

    public void pauseSimulation() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public Simulation(int width, int height, int herbivoreCount, int predatorCount,
            int grassCount, int rockCount, int treeCount) {
        this.map = new Map(width, height);
        this.renderer = new Renderer();
        this.turnCounter = 0;

        this.initActions = new ArrayList<>();
        initActions.add(new InitMapActions(herbivoreCount, predatorCount,
                grassCount, rockCount, treeCount));

        this.turnActions = new ArrayList<>();
        turnActions.add(new MoveCreaturesAction());
        turnActions.add(new SpawnGrassAction());
        turnActions.add(new SpawnHerbivoresActions());

        for (Action action : initActions) {
            action.execute(map);
        }
    }

    public void nextTurn() {
        for (Action action : turnActions) {
            action.execute(map);
        }
        turnCounter++;
        renderer.render(map, this);
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 10, 5, 2, 5, 5, 5);

        SimulationController controller = new SimulationController(simulation);
        controller.startControlLoop();
    }
}