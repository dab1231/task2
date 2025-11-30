import java.util.List;

public class Herbivore extends Creature {

    public Herbivore() {
        this.setHealth(5);
        this.setSpeed(1);
    }

    public Herbivore(int health, int speed){
        this.setHealth(health);
        this.setSpeed(speed);
    }

    @Override
    public void makeMove(Map map) {
        PathFinder pathFinder = new PathFinder();
        Coordinate currentPos = new Coordinate(this.getXPos(), this.getYPos());

        Coordinate nearestTarget = pathFinder.findNearestTarget(map, currentPos, Grass.class);
        if (nearestTarget != null) {
            List<Coordinate> path = pathFinder.findPath(currentPos, nearestTarget, map);
            if (path != null) {
                for(int i = 1; i < Math.min(getSpeed() + 1, path.size()); i++) {
                    Coordinate target = path.get(i);

                    if(map.getEntity(target) instanceof Grass) {
                        map.removeEntity(target);
                    }

                    map.moveEntity(currentPos, target);
                    currentPos = target;

                    if(target.equals(nearestTarget)) {
                        break;
                    }
                }
            }
        }
    }
}
