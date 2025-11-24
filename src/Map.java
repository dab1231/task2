import java.util.HashMap;

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

    public void addEntity(Coordinate coordinate, Entity entity){
        if(coordinate.getX() < 0 || coordinate.getX() >= width 
            || coordinate.getY() < 0 || coordinate.getY() >= height || isOccupied(coordinate)){
            throw new IllegalArgumentException("Coordinate out of bounds or already occupied");
        }
        entities.put(coordinate, entity);
        entity.setPosition(coordinate.getX(), coordinate.getY());
    }

    public void removeEntity(Coordinate coordinate){
        entities.remove(coordinate);
    }

    public Entity getEntity(Coordinate coordinate){
        return entities.get(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate){
        return entities.containsKey(coordinate);
    }
}
