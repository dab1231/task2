import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private Renderer renderer;
    private List<Action> initActions;
    private List<Action> turnActions;
    private int turnCounter;

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public Simulation(int width, int height, int herbivoreCount, int predatorCount,
            int grassCount, int rockCount, int treeCount) {
        this.map = new Map(width, height); // БЕЗ типа!
        this.renderer = new Renderer();
        this.turnCounter = 0;

        this.initActions = new ArrayList<>();
        initActions.add(new InitMapActions(herbivoreCount, predatorCount,
                grassCount, rockCount, treeCount));

        this.turnActions = new ArrayList<>();
        turnActions.add(new MoveCreaturesAction());

        // Выполнить инициализацию сразу
        for (Action action : initActions) {
            action.execute(map);
        }
    }

    public void nextTurn() {
        for (Action action : turnActions) {
            action.execute(map);
        }
        turnCounter++;
        renderer.render(map);
    }

    public void startSimulation() {
        while (true) {
            clearConsole();
            nextTurn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseSimulation() {
        // Приостановить цикл (опционально, сложнее)
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(10, 10, 2, 1, 5, 3, 2);
        simulation.startSimulation();
    }
}