package controller;

import model.MastermindModel;


/**
 * 
 * @author Zachary Florez
 * @course CSC 335
 * @class MastermindController
 *
 */
public class MastermindController {
	
	MastermindModel model;
	private int rightCount = 0;
	private int wrongCount = 0;
	
	/*
	 * Constructor method, have to input a MastermindModel (which is
	 * the answer created by the game). 
	 */
	public MastermindController(MastermindModel model) {
		this.model = model;
	}
 
	
	/** 
	 * This method returns whether a string guess is guessed correctly or not. 
	 * It first calls other method in class to get a correct count, if that 
	 * count is equal to four, then the guess was correct. 
	 * 
	 * @param String guess
	 * @return boolean true or false.
	 */
    public boolean isCorrect(String guess) {
    	getRightColorRightPlace(guess);
    	System.out.printf("Colors in the correct place: %d\n", rightCount);
    	
    	// If statement to no try and guess colors that are in the wrong place if 
    	// you already guessed the answer right
    	if (rightCount == 4) {
    		System.out.println("Colors correct but in the wrong position: 0");
    		System.out.println();
    		return true;
    	} else {
    		getRightColorWrongPlace(guess);
        	System.out.printf("Colors correct but in the wrong position: %d\n", wrongCount);
    	}
    	
    	System.out.println();
    	
    	// return false if they haven't won yet (String guess was wrong).
    	return false;
    }
    
    
    /**
     * This method loops through the correct String of colors and sees 
     * if a color is in the right place and in the right position.
     * 
     * @param String guess
     * @return Integer count how many right colors in right place 
     */
    public int getRightColorRightPlace(String guess) { 
    	// reset rightCount back to zero every time for a new guess. 
    	rightCount = 0;
    	
    	// Counts how many times color is in the right place. 
    	// returns that count
    	for (int i = 0; i < 4; i ++) {
    		if (guess.charAt(i) == this.model.getColorAt(i)) {
    			rightCount ++;
    		}
    	}
    	
    	return rightCount; 
    }
    
    
    /**
     * This method loops through all of the colors in the correct string 
     * and also loops through all of the colors in the String guess to 
     * see if there are any colors that supposed to be in the right answer 
     * but are just in a different spot. 
     * 
     * @param String guess
     * @return Integer count of how many right colors in the wrong place.
     */
    public int getRightColorWrongPlace(String guess) {
    	// reset wrongCount back to zero every time for a new guess. 
    	wrongCount = 0;
    	
    	// Outer loop loops through model answer.
    	for (int i = 0; i < 4; i++) {
    		char answerColor = this.model.getColorAt(i);
    		
    		// Inner loop loops through guess answer.
    		for (int j = 0; j < 4; j ++) {			
    			char guessColor = guess.charAt(j);
    			
    			// First if statement to see if a color is right but in wrong position.
    			if ((guessColor == answerColor) && (i != j) ) {
    				wrongCount ++;
    				break;
    			}
    			
    			// Break the for loop if the color is right and in the correct positon
    			// so we don't repeat. 
    			if (guessColor == answerColor) {
    				break;
    			}
    		}
    	}
    	return wrongCount;
    }
}