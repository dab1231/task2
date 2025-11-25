import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Predator extends Creature {
    private int attackPower;

    public Predator() {
        this.health = 10;
        this.speed = 2;
        this.attackPower = 3; 
    }

    public Predator(int health, int speed, int attackPower) {
        this.health = health;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(Map map) {
        Coordinate currentPos = new Coordinate(this.getXPos(), this.getYPos());

        Coordinate up = new Coordinate(currentPos.getX(), currentPos.getY() + 1);
        Coordinate down = new Coordinate(currentPos.getX(), currentPos.getY() - 1);
        Coordinate left = new Coordinate(currentPos.getX() - 1, currentPos.getY());
        Coordinate right = new Coordinate(currentPos.getX() + 1, currentPos.getY());

        List<Coordinate> possibleMoves = new ArrayList<>();

        if(!(map.isOccupied(up)) && up.getY() < map.getHeight()){
            possibleMoves.add(up);
        }
        if(!(map.isOccupied(down)) && down.getY() >= 0){
            possibleMoves.add(down);
        }
        if(!(map.isOccupied(left)) && left.getX() >= 0){
            possibleMoves.add(left);
        }
        if(!(map.isOccupied(right)) && right.getX() < map.getWidth()){
            possibleMoves.add(right);
        }

        if(possibleMoves.isEmpty()){
            return; 
        }
        
        Random rand = new Random();
        int point = rand.nextInt(possibleMoves.size());
        Coordinate moveTo = possibleMoves.get(point);
        map.moveEntity(currentPos, moveTo);
    }
}
