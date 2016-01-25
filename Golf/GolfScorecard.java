
/**
 * Blueprint for "GolfScorecard" object
 * 
 * @author Hannah Pang
 * @version January 24, 2016
 */

import java.util.*;

public class GolfScorecard
{
    // instance variables 
    int holeNumber;
    int par;
    int actual;
    int cumulativePar = 0;
    int cumulativeActual = 0;

    /**
     * Constructor for objects of class GolfScorecard
     */
    
    public GolfScorecard(int holeNumberInput, int parInput, int actualInput)
    {
        holeNumber = holeNumberInput;
        par = parInput;
        actual = actualInput;
    }
    
    // parameter: current hole being analyzed
    // adds par and actual score from the current hole to the cumulative totals
    public void add(GolfScorecard current) 
    {
        cumulativePar += current.par;
        cumulativeActual += current.actual;
    }
    
    // returns name of hole (birdie, bogey, etc) based on player's actual score compared to par
    public String score()
    {
        int difference = par - actual;
        
        if (difference == -2) {
            return holeNumber + ". double bogey";
        } else if (difference == -1) {
            return holeNumber + ". bogey";
        } else if (difference == 1) {
            return holeNumber + ". birdie";
        } else if (difference == 2) {
            return holeNumber + ". eagle";
        } else {
            return holeNumber + ". par";
        }
    }
    
    // returns final result (amt over/below par) based on player's actual cumulative score compared to cumulative par
    public String finalScore()
    {
        int finalDifference = cumulativePar - cumulativeActual;
        
        if (finalDifference > 0) {
            return finalDifference + " below par";
        } else if (finalDifference < 0) {
            return Math.abs(finalDifference) + " over par";
        } else {
            return "Par";
        }
    }
}
