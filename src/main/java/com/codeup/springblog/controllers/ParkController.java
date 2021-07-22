package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Park;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParkController {
  @GetMapping("/parks")
  public String showParks(Model model){
    Park parkOne = new Park("Bork");
    Park parkTwo = new Park("Bruv");
    Park parkThree = new Park("Home");
    List<Park> parks = new ArrayList();

    parks.add(parkOne);
    parks.add(parkTwo);
    parks.add(parkThree);

    model.addAttribute("parks", parks);

    return "parks";
  }

}
