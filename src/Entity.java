public abstract class Entity {
    private int xPos;
    private int yPos;

    public Entity(){
        this.xPos = 0;
        this.yPos = 0;
    }

    public int getXPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }

    public void setPosition(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
