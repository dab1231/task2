import java.io.Console;

public class Simulation {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        
        Map map = new Map(10, 10);
        Renderer renderer = new Renderer();
        Entity tree = new Tree();
        map.addEntity(new Coordinate(2, 3), tree);
        Entity rock = new Rock();
        map.addEntity(new Coordinate(5, 5), rock);
        Entity grass = new Grass();
        map.addEntity(new Coordinate(0, 0), grass);
        Herbivore herbivore = new Herbivore();
        map.addEntity(new Coordinate(7, 8), herbivore);
        Predator predator = new Predator();
        map.addEntity(new Coordinate(4, 4), predator);
        Entity grass2 = new Grass();
        map.addEntity(new Coordinate(1, 1), grass2);
        renderer.render(map);

        while (true) {
            herbivore.makeMove(map);
            predator.makeMove(map);
            renderer.render(map);
            try {
                Thread.sleep(1000); // Pause for 1 second between each move
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
        }
    }
}
