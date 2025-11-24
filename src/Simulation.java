public class Simulation {
    public static void main(String[] args) {
        
        Map map = new Map(10, 10);
        Renderer renderer = new Renderer();
        Entity tree = new Tree();
        map.addEntity(new Coordinate(2, 3), tree);
        Entity rock = new Rock();
        map.addEntity(new Coordinate(5, 5), rock);
        Entity grass = new Grass();
        map.addEntity(new Coordinate(0, 0), grass);
        Entity herbivore = new Herbivore();
        map.addEntity(new Coordinate(7, 8), herbivore);
        Entity predator = new Predator();
        map.addEntity(new Coordinate(4, 4), predator);
        Entity grass2 = new Grass();
        map.addEntity(new Coordinate(1, 1), grass2);
        renderer.render(map);
    }
}
