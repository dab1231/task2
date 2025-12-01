import java.util.List;

public class Predator extends Creature {
    private int attackPower;

    public Predator() {
        setHealth(10);
        setSpeed(2);
        attackPower = 3;
    }

    public Predator(int health, int speed, int attackPower) {
        this.setHealth(health);
        this.setSpeed(speed);
        this.attackPower = attackPower;
    }

    @Override
    protected Class<?> getTargetType() {
        return Herbivore.class;
    }

    @Override
    protected void onTargetReached(Map map, Coordinate target) {
        Entity entity = map.getEntity(target);
        if (entity instanceof Herbivore herbivore) {
            herbivore.setHealth(herbivore.getHealth() - attackPower);
            if (herbivore.getHealth() <= 0) {
                map.removeEntity(target);
            }
        }
    }
}
