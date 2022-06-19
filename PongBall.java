public class PongBall
{
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    /**
     * Constructor for objects of class PongBall
     */
    public PongBall()
    {
        x = 0;
        y = 0;
        xVel = 0;
        yVel = 0;
    }
    public PongBall(int initX, int initY, int initXVel, int initYVel)
    {
        x = initX;
        y = initY;
        xVel = initXVel;
        yVel = initYVel;  
    }
    
    public void bounceX()
    {
        xVel *= -1;
    }
    public void bounceY()
    {
        yVel *= -1;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void move()
    {
        x += xVel;
        y += yVel;
    }
}
