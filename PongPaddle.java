public class PongPaddle
{
    private int x;
    private int y;
    private int width;
    private int height;
    
    public PongPaddle()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }
    public PongPaddle(int top, int left, int w, int h)
    {
        x = left;
        y = top;
        width = w;
        height = h;
    }
    
    public int getBottomY()
    {
        return y + height - 1;
    }
    public int getLeftX()
    {
        return x;
    }
    public int getRightX()
    {
        return x + width - 1;
    }
    public int getTopY()
    {
        return y;
    }
    public void moveDown(int d)
    {
        y += d;
    }
    public void moveUp(int d)
    {
        y -= d;
    }
}
