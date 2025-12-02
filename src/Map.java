import java.util.HashMap;
import java.util.Map.Entry;

public class Map {
    private int width;
    private int height;
    private HashMap<Coordinate, Entity> entities;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public java.util.HashMap<Coordinate, Creature> getCreatures() {
        java.util.HashMap<Coordinate, Creature> creatures = new java.util.HashMap<>();

        for (Entry<Coordinate, Entity> entry : entities.entrySet()) {
            if (entry.getValue() instanceof Creature) {
                creatures.put(entry.getKey(), (Creature) entry.getValue());
            }
        }
        return creatures;
    }

    public int getGrassCount() {
        int count = 0;
        for (Entity entity : entities.values()) {
            if (entity instanceof Grass) {
                count += 1;
            }
        }
        return count;
    }

    public int getHerbivoreCount() {
        int count = 0;
        for (Entity entity : entities.values()) {
            if (entity instanceof Herbivore) {
                count += 1;
            }
        }
        return count;
    }

    public void addEntity(Coordinate coordinate, Entity entity) {
        if (coordinate.getX() < 0 || coordinate.getX() >= width
                || coordinate.getY() < 0 || coordinate.getY() >= height || isOccupied(coordinate)) {
            throw new IllegalArgumentException("Coordinate out of bounds or already occupied");
        }
        entities.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        entities.remove(coordinate);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entities.get(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate) {
        return entities.containsKey(coordinate);
    }

    public void moveEntity(Coordinate from, Coordinate to) {
        Entity entity = entities.get(from);
        if (entity == null) {
            throw new IllegalArgumentException("No entity at the specified coordinate");
        }
        if (to.getX() < 0 || to.getX() >= width
                || to.getY() < 0 || to.getY() >= height) {
            throw new IllegalArgumentException("Target coordinate is occupied ");
        }
        entities.remove(from);
        entities.remove(to);
        entities.put(to, entity);

    }
}
