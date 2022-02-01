package model;
import java.util.Random;

/**
 * 
 * @author Zachary Florez
 * @course CSC 252
 * @class MastermindModel
 *
 */
public class MastermindModel {
	
	//private variable(s) to store the answer
	private String answer = new String();
	private String[] colors = {"r", "o", "y", "g", "b", "p"};
	
	/*
	 * Constructor, no parameters are needed, creates a model 
	 * from scratch brand new every time. 
	 */
    public MastermindModel() { 
    	
    	this.answer = "";
    	Random rand = new Random();
    	
    	// loop four times to generate a random answer. 
    	int i = 0;
    	while (i < 4) {
    		int random = rand.nextInt(6);
    		this.answer += colors[random];
    		i ++;
    	}
    	
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	// TODO Take answer and somehow store it as your answer. Make sure the getColorAt method 
    	// still works
    	this.answer = answer;
    }

    /**
     * This method gets the specific color at index "index" when seeing if 
     * color is correct in controller class. 
     * 
     * @return: char at specified index in answer. 
     */
    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	return this.answer.charAt(index);
    }   
}