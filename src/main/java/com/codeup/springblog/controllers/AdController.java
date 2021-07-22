package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.AdRepository;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
  private final AdRepository adDao;
//  A variable set to final is just like a constant in js, IT CANNOT BE CHANGED.
  public AdController(AdRepository adDao) {
    this.adDao = adDao;
  }

  @GetMapping("/ads")
  public String showAds(Model model){
    model.addAttribute("ads",adDao.findAll());
    return "ads/index";
  }
//Below works because were using the same class properties names are the sql column names?
  @GetMapping("/ads/{id}")
  public String viewOne(@PathVariable long id, Model model){
    Ad ad = adDao.findById(id);
    model.addAttribute("ad",ad);
    return "ads/show";
  }

//  Title has to be exact?
  @GetMapping("/ads/title/{title}")
  public String viewOneTitle(@PathVariable String title, Model model){
    Ad ad = adDao.findFirstByTitle(title);
    model.addAttribute("ad",ad);
    return "ads/show";
  }

}
