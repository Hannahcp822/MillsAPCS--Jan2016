
/**
 * Write a description of class Player here.
 * 
 * @author Hannah Pang
 * @version January 29, 2016
 */
public class Player
{
    // instance variables
    private int position;
    private int currentMove;
    private boolean reachEnd;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        position = 0;
        currentMove = 0;
        reachEnd = false;
    }

    public int moveCells(int currentMove)
    {
        if (currentMove == 4 || currentMove == 6) {
            moveBackward(currentMove);
        } else {
            moveForward(currentMove);
        }
        return position;
    }
    
    /**
     * moveForward method - moves player position forward, as defined by parameter  
     * @param      currentMove (how many cells to move forward)
     */
    public int moveForward(int currentMove)
    {
        position += currentMove;
        if (position == 40) {
            setEndResult();
        }
        return position;
    }
    
    /**
     * moveackward method - moves player position backward, as defined by parameter 
     * @param      currentMove (how many cells to move backward, either 4 or 6)
     */
    public int moveBackward(int currentMove)
    {
        position -= currentMove;
        return position;
    }
    
    public void setEndResult()
    {
        reachEnd = true;
    }
    
    public void returnToStart()
    {
        position = 0;
    }
    
    public String toString()
    {
        if (reachEnd == false) {
            return "0";
        } else {
            return "END";
        }
    }
}
