import java.util.List;

public class Herbivore extends Creature {

    public Herbivore() {
        this.setHealth(10);
        this.setSpeed(2);
    }

    public Herbivore(int health, int speed){
        this.setHealth(health);
        this.setSpeed(speed);
    }

    @Override
    protected Class<?> getTargetType(){
        return Grass.class;
    }

    @Override
    protected void onTargetReached(Map map, Coordinate target){
        if(map.getEntity(target) instanceof Grass){
            map.removeEntity(target);
        }
    }
}
