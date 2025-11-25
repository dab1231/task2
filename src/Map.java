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

    public void moveEntity(Coordinate from, Coordinate to){
        Entity entity = entities.get(from);
        if(entity == null) {
            throw new IllegalArgumentException("No entity at the specified coordinate");
        }
        if(to.getX() < 0 || to.getX() >= width 
            || to.getY() < 0 || to.getY() >= height){
            throw new IllegalArgumentException("Target coordinate is occupied ");
        }
        entities.remove(from);
        entities.remove(to);
        entities.put(to, entity);
        entity.setPosition(to.getX(), to.getY());
            
    }
}
