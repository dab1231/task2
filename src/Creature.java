import java.util.List;

public abstract class Creature extends Entity {
    private int speed;
    private int health;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void makeMove(Map map){
        PathFinder pathFinder = new PathFinder();
        Coordinate currentPos = new Coordinate(this.getXPos(), this.getYPos());

        Coordinate nearestTarget = pathFinder.findNearestTarget(map, currentPos, getTargetType());
        if (nearestTarget != null) {
            List<Coordinate> path = pathFinder.findPath(currentPos, nearestTarget, map);
            if (path != null) {
                for(int i = 1; i < Math.min(getSpeed() + 1, path.size()); i++) {
                    Coordinate target = path.get(i);
                    
                    onTargetReached(map, target);
                    map.moveEntity(currentPos, target);
                    currentPos = target;

                    if(target.equals(nearestTarget)) {
                        break;
                    }
                }
            }
        }
    }

    protected abstract Class<?> getTargetType();    

    protected abstract void onTargetReached(Map map, Coordinate target);
}
