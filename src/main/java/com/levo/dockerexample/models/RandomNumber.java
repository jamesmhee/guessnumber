package com.levo.dockerexample.models;

import java.lang.reflect.Array;

import org.springframework.stereotype.Service;

@Service
public class RandomNumber {
    
    private String number;        
    
    public void setNumber(String number){        
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    public static String generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        try {
            int randomNumber = (int) (Math.random() * range) + min;
            if (randomNumber >= 0 && randomNumber <= 999) {
                return String.format("%03d", randomNumber);  // Format as three digits with leading zeros
            } else {
                throw new IllegalArgumentException("Invalid random number: " + randomNumber);
            }        
        } catch (IllegalArgumentException err) {
            System.out.println(err);
            throw err;
        }
    }

    public String guessNumber(String userInput, String randomNumber){
        int score = 0;
        boolean checkTrue = false;
        try{            
            for(int i = 0; i < randomNumber.length(); i++){
                char digit = randomNumber.charAt(i);
                if (userInput.contains(String.valueOf(digit))) {
                    score++;
                    checkTrue = true;
                } else {
                    score--;
                }
            }
    
            String correct = (score > 0 || checkTrue) ? "Correct" : "Incorrect";
            return correct;
        } catch (Error error){
            throw error;
        }
    }
    

}
