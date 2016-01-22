
/**
 * Write a description of class GolfScorecard here.
 * 
 * @author Hannah Pang
 * @version January 22, 2016
 */
public class GolfScorecard
{
    // instance variables 
    int cumulativePar;
    int cumulativeScore;

    /**
     * Constructor for objects of class GolfScorecard
     */
    public GolfScorecard(int par1, int score1,
                         int par2, int score2,
                         int par3, int score3,
                         int par4, int score4)
    {
        // initialise instance variables
        cumulativePar = par1 + par2 + par3 + par4;
        cumulativeScore = score1 + score2 + score3 + score4;
    }

    /**
     * An example of a method - 
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void name(int holeNumber, int par, int score)
    {
        int difference = par - score;
        String name = holeNumber + ". ";
        if (difference > 0) {
            
        } else if (difference < 0) {
            
        } else {
            name += "Par";
    }
}
