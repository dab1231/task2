import java.util.Random;

public class InitMapActions implements Action {
    private final int herbivoreCount;
    private final int predatorCount;
    private final int grassCount;
    private final int rockCount;
    private final int treeCount;
    private Random random = new Random();

    public InitMapActions(int herbivoreCount, int predatorCount, int grassCount, int rockCount, int treeCount) {
        this.herbivoreCount = herbivoreCount;
        this.grassCount = grassCount;
        this.predatorCount = predatorCount;
        this.rockCount = rockCount;
        this.treeCount = treeCount;
    }

    private void addRandomEntity(Map map, Entity entity) {
        Coordinate coordinate = getRandomFreeCoordinate(map);
        map.addEntity(coordinate, entity);
    }

    private Coordinate getRandomFreeCoordinate(Map map) {
        Coordinate coordinate;
        do {
            coordinate = new Coordinate(
                    random.nextInt(map.getWidth()),
                    random.nextInt(map.getHeight()));
        } while (map.isOccupied(coordinate));
        return coordinate;
    }

    @Override
    public void execute(Map map) {
        for (int i = 0; i < herbivoreCount; i++) {
            Herbivore herbivore = new Herbivore();
            addRandomEntity(map, herbivore);
        }

        for (int i = 0; i < predatorCount; i++) {
            Predator predator = new Predator();
            addRandomEntity(map, predator);
        }

        for (int i = 0; i < grassCount; i++) {
            Grass grass = new Grass();
            addRandomEntity(map, grass);
        }

        for (int i = 0; i < rockCount; i++) {
            Rock rock = new Rock();
            addRandomEntity(map, rock);
        }

        for (int i = 0; i < treeCount; i++) {
            Tree tree = new Tree();
            addRandomEntity(map, tree);
        }
    }

}
