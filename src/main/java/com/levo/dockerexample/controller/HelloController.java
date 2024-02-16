package com.levo.dockerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.levo.dockerexample.models.RandomNumber;
import com.levo.dockerexample.models.GameEntities;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import com.levo.dockerexample.models.GameRepository;

@Controller
public class HelloController {
		
	@Autowired
	private GameRepository GameRepository;	

	@Autowired	
	private RandomNumber number;		
			
	@GetMapping("/")
	public String Main(ModelMap Model) {		
		// Create RandomNumber
		String random = number.generateRandomNumber(0, 999);	
		// get data from db.	
		List<GameEntities> allGames = GameRepository.findAll();		
		// Store Guessnumber in Object game
		number.setNumber(random);
		// Get guessnumber from Object game
		String randomNum = number.getNumber();		
		// Show data to view.
		Model.addAttribute("randomNumber", randomNum);
		if(allGames.size() > 0){			
        	Model.addAttribute("games", allGames);			
		}		
		return "index"; // Return the logical view name without prefix and suffix
	}	

	@PostMapping("/submit")
	public ModelAndView Submit(@RequestParam("inputNumber") String userInput, ModelMap Model){							
		
		String randomNumber = number.getNumber();
		// Set guessnumber to object game
		GameEntities game = new GameEntities();
		game.setGuessNumber(randomNumber);
		// Set userinput to object game
		String check = number.guessNumber(userInput, randomNumber);				
		game.setUserGuess(userInput);
		Model.addAttribute("randomNumber", randomNumber);		
		// Set Userguess number from userinput to game object.
		if(check == "Correct"){
			game.upScore(1);
		}else{
			game.delScore(1);
		}		
		GameRepository.saveAndFlush(game);						

		return new ModelAndView("redirect:"+ "/");
	}

	@RequestMapping("/clear")
	public ModelAndView Clear(){
		try{						
			// for delete all history
			GameRepository.deleteAll();
			System.out.println("HISTORY CLEARED");			
		}catch(Error error){
			System.out.println(error);
		}
		
		return new ModelAndView("redirect:"+ "/");
	}


	
	
	
	
}