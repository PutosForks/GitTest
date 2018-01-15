package com.example.baseball.controller;


import com.example.baseball.domain.Player;
import com.example.baseball.service.PlayerExceptionClass;
import com.example.baseball.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/players") // ①
public class PlayerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ErrorAttributes errorAttributes;

    @GetMapping
    public String index(Model model) {
        List<Player> players = playerService.findall();
        model.addAttribute("players", players); // ③
        return "players/index"; // ④
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/new";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/show";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ExceptionHandler({PlayerExceptionClass.class})
    public ModelAndView create(Model model, @Valid @ModelAttribute Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ModelAndView("players/new");
        try {
            playerService.save(player);
            ModelAndView modelAndView = new ModelAndView("players/index");
            modelAndView.addObject("players", playerService.findall());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("players/new", "error", e.getMessage());
        }
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Player player) {
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }
}