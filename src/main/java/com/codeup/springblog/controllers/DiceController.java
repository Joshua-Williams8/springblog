package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class DiceController {

  private static Random random = new Random();

  @GetMapping("/roll-dice")
  public String rollDice(){
    return "rolldice";
  }

  @GetMapping("/roll-dice/{guess}")
  public String rolledDice(@PathVariable String guess, Model model){
    model.addAttribute("guess",guess);
    int roll = random.nextInt(6) + 1;
    int rollTwo = random.nextInt(6) + 1;
    int rollThree = random.nextInt(6) + 1;
    int rollsCorrect = 0;
//
    if(roll == Integer.parseInt(guess)){
      rollsCorrect = rollsCorrect + 1;
    }
    if(rollTwo == Integer.parseInt(guess)){
      rollsCorrect = rollsCorrect + 1;

    }
    if(rollThree == Integer.parseInt(guess)){
      rollsCorrect = rollsCorrect + 1;
    }


    model.addAttribute("roll",roll);
    model.addAttribute("rollTwo",rollTwo);
    model.addAttribute("rollThree",rollThree);
    model.addAttribute("rollsCorrect",rollsCorrect);

    return "rolldice";
  }

}
