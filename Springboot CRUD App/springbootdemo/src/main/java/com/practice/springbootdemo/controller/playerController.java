package com.practice.springbootdemo.controller;

import com.practice.springbootdemo.Player;
import com.practice.springbootdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class playerController {
    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/showNewPlayerForm")
    public String showNewPlayerForm(Model model){
        Player p = new Player();
        model.addAttribute("player",p);
        return "new_player";
    }

    @RequestMapping(value = "/savePlayer",method = RequestMethod.POST)
    public String savePlayer(@ModelAttribute("player") Player player){
        playerService.addPlayer(player);
        return "redirect:/";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getAllPlayers(Model model){
        List<Player> allPlayers = playerService.getAllPlayers();
        model.addAttribute("listPlayers",allPlayers);
        return "index";
    }

    @RequestMapping(value = "/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") Long id,Model model){
        Optional<Player> p = playerService.getPlayerById(id);
        model.addAttribute("player",p);
        return "update_player";
    }

    @RequestMapping(value = "/deletePlayer/{id}")
    public String deletePlayer(@PathVariable("id") Long id){
        playerService.deletePlayerById(id);
        return "redirect:/";
    }
}
