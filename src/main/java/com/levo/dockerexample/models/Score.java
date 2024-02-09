package com.levo.dockerexample.models;

public class Score {
    private Integer score = 0;

    public void setScore(Integer score){
        this.score += score;
    }

    public void delScore(Integer score){
        this.score -= score;
    }

    public void resetScore(){
        this.score = 0;
    }

    public Integer getScore(){
        return this.score;
    }

    public String calculateScore(String userInput, String randomNumber){        

        String formatScore = getScore() + "";
        return formatScore;
        // for(int i = 0;i < randomNumber.length() ; i++){
        //     for(int j = 0 ; j < userInput.length() ; j++){
        //         System.out.println(randomNumber + userInput);
        //     }
        // }
    }
}
