// package com.levo.dockerexample.models;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Column;

// @Entity
// @Table(name="users")
// public class Users {

//     @Id 
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     @Column(name="user_id")
//     private Integer user_id;
    
//     @Column(name="name", length=20)
//     private String name;
    
//     @Column(name="score")
//     private int score;

//     // Constructors
//     public Users() {}

//     public Users(String name, int score) {
//         this.name = name;
//         this.score = score;
//     }

//     // Getters and setters
//     public Integer getId() {
//         return user_id;
//     }

//     public void setId(Integer user_id) {
//         this.user_id = user_id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getScore() {
//         return score;
//     }

//     public void setScore(int score) {
//         this.score = score;
//     }
// }
