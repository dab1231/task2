import java.util.Scanner;

public class SimulationController {
    private final Simulation simulation;
    private final SimulationRunnable simulationRunnable;
    private Thread simulationThread;

    public SimulationController(Simulation simulation) {
        this.simulation = simulation;
        this.simulationRunnable = new SimulationRunnable(simulation);
        this.simulationThread = null;
    }

    public void startControlLoop() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Симуляция готова. Введите 'start', 'pause' или 'exit'.");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "start":
                    handleStart();
                    break;
                case "pause":
                    handlePause();
                    break;
                case "exit":
                    handleExit();
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private void handleStart() {
        if (simulation.isRunning()) {
            System.out.println("Симуляция уже идет.");
            return;
        }

        System.out.println("--- Симуляция запущена ---");
        simulation.startSimulationThread();

        if (simulationThread == null || !simulationThread.isAlive()) {
            simulationThread = new Thread(simulationRunnable);
            simulationThread.start();
        }
    }

    private void handlePause() {
        if (!simulation.isRunning()) {
            System.out.println("Симуляция уже приостановлена.");
            return;
        }

        simulation.pauseSimulation();
        System.out.println("--- Симуляция ПРИОСТАНОВЛЕНА ---");
    }

    private void handleExit() {
        System.out.println("Завершение программы...");
        simulation.pauseSimulation();

        if (simulationThread != null && simulationThread.isAlive()) {
            simulationThread.interrupt();
            try {
                simulationThread.join(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}