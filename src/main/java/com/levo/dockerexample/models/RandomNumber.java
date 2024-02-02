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

    public String guessNumber(String userInput, String randoNumber){
        String correct = "";
        for(int i=0;i<userInput.length();i++){
            if(userInput.charAt(i) == randoNumber.charAt(i)){
                correct = "Correct";
            }else{
                correct = "Not Correct";
            }
        }
        return correct;
        
    }

}
