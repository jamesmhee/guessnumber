package com.levo.dockerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// import com.levo.dockerexample.models.History;
import com.levo.dockerexample.models.RandomNumber;
import com.levo.dockerexample.models.Score;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	
	@Autowired	
	private RandomNumber number;
	Score point = new Score();
	// private History history;
	static ArrayList<String> history = new ArrayList<String>();

	@GetMapping("/")
	public String Main(ModelMap Model) {		
		String random = RandomNumber.generateRandomNumber(0, 999);
		number.setNumber(random);		
		String randomNum = number.getNumber();
		Integer getScore = point.getScore();			
		Model.addAttribute("randomNumber", randomNum);
		if(history.size() > 0){
			Model.addAttribute("userInput", history);		
		}
		Model.addAttribute("score", getScore);		
		return "index"; // Return the logical view name without prefix and suffix
	}	

	@PostMapping("/submit")
	public ModelAndView Submit(@RequestParam("inputNumber") String userInput, ModelMap Model){				
		String randomNum = number.getNumber();				
		Model.addAttribute("randomNumber", randomNum);
		history.add(randomNum);		
		String check = number.guessNumber(userInput, randomNum);
		if(check == "Correct"){
			point.setScore(1);
		}else{
			point.delScore(1);
		}
		List<String> historyList = history.subList(0, history.size()-1); // For 		
		Model.addAttribute("userInput", historyList);				

		return new ModelAndView("redirect:"+ "/");
	}

	@RequestMapping("/clear")
	public static ModelAndView Clear(){
		try{
			history.clear();			
			System.out.println("HISTORY CLEARED");			
		}catch(Error error){
			System.out.println(error);
		}
		
		return new ModelAndView("redirect:"+ "/");
	}
	
	
}