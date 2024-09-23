/**
 *
 * @author Ashton Hoeft
 * @version January 20, 2023
 * 
 * This program tests the Score class and its methods.
 * 
 */

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        //Declare Scores and Random objects
        Scores scores = new Scores(16);
        Random rand = new Random();
        
        //Add 32 random integers between -10 and 10 to scores
        for(int i = 0; i < 32; i++) {
            scores.add(rand.nextInt(-10, 11));
        }
        
        //Print contents of scores
        System.out.println(scores.toString());
        
        //Add 6 to scores
        scores.add(6);
        
        //Print the length of scores
        System.out.println("The length of scores is " + scores.size());
        
        //Print out the random score that was removed from scores
        System.out.println("The score removed from scores is " + scores.remove());
        
        //Print and store the score at index 20
        System.out.println("The score at index 20 is " + scores.get(20));
        int number = scores.get(20);
        
        //Print how many times number is in scores
        System.out.println("The score " + number + " occurs " + scores.getFrequencyOf(number) + " time(s)");
        
        //Remove score at index 20
        System.out.println(scores.remove(scores.get(20)) + " was removed");
        
        //Print new frequency
        System.out.println("The new frequency of " + number + " is " + scores.getFrequencyOf(number));
        
        //Print the contents of updated scores
        System.out.println(scores.toString());
        
        //Check if 7 is in scores
        System.out.println("Does scores contain 7: " + scores.contains(7));
    }
    
}