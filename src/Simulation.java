public class Simulation {
    public static void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
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
        map.addEntity(new Coordinate(2, 2), herbivore);
        Predator predator = new Predator();
        map.addEntity(new Coordinate(9, 9), predator);
        Entity grass2 = new Grass();
        map.addEntity(new Coordinate(1, 1), grass2);
        Herbivore herbivore2 = new Herbivore();
        map.addEntity(new Coordinate(3, 3), herbivore2);
        renderer.render(map);

        while (true) {
            clearConsole();
            Coordinate herbivorePos = new Coordinate(herbivore.getXPos(), herbivore.getYPos());
            if(map.getEntity(herbivorePos) == herbivore) {
                herbivore.makeMove(map);
            }

            Coordinate predatorPos = new Coordinate(predator.getXPos(), predator.getYPos());
            if(map.getEntity(predatorPos) == predator) {
                predator.makeMove(map);
            }

            Coordinate herbivore2Pos = new Coordinate(herbivore2.getXPos(), herbivore2.getYPos());
            if(map.getEntity(herbivore2Pos) == herbivore2) {
                herbivore2.makeMove(map);
            }

            renderer.render(map);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
