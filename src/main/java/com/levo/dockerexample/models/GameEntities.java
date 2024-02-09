package com.levo.dockerexample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="game")
public class GameEntities {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="userguess")
    private String userGuess;

    @Column(name="guessnumber")
    private String guessNumber;

    @Column(name="score")
    private Integer score = 0;

    public GameEntities(){}    
    
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUserGuess(){
        return this.userGuess;
    }

    public void setUserGuess(String userGuess){
        this.userGuess = userGuess;
    }

    public String getGuessNumber(){
        return this.guessNumber;
    }

    public void setGuessNumber(String guessNumber){
        this.guessNumber = guessNumber;
    }

    public Integer getScore(){
        return this.score;
    }

    public void upScore(Integer Score){
        this.score += Score;
    }

    public void delScore(Integer Score){
        this.score -= Score;
    }
    


}
