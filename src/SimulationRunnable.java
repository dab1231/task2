public class SimulationRunnable implements Runnable{
    private Simulation simulation;
    public SimulationRunnable(Simulation simulation){
        this.simulation = simulation;
    }

    @Override
    public void run(){
        while (simulation.isRunning()) {
            Simulation.clearConsole();
            simulation.nextTurn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
