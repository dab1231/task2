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
    public void makeMove(Map map) {
        PathFinder pathFinder = new PathFinder();
        Coordinate currentPos = new Coordinate(this.getXPos(), this.getYPos());

        Coordinate nearestTarget = pathFinder.findNearestTarget(map, currentPos, Herbivore.class);
        if (nearestTarget != null) {
            List<Coordinate> path = pathFinder.findPath(currentPos, nearestTarget, map);
            if (path != null) {

                for(int i = 1; i < Math.min(getSpeed() + 1, path.size()); i++) {
                    Coordinate target = path.get(i);
                    Entity entity = map.getEntity(target);

                    if(entity instanceof Herbivore herbivore) {
                        herbivore.setHealth(herbivore.getHealth() - attackPower);
                        if(herbivore.getHealth() <= 0) {
                            map.removeEntity(target);
                        }
                    }
                    map.moveEntity(currentPos, target);
                    currentPos  = target;
                }
            }
        }
    }
}
