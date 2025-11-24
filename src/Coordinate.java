import java.util.Objects;

public class Coordinate {
    private int xPos;
    private int yPos;
    
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }

    public Coordinate(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        if(xPos != other.xPos) return false;
        if(yPos != other.yPos) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(xPos,yPos);   
    }

}
