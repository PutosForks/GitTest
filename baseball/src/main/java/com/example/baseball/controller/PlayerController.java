package com.example.baseball.controller;


import com.example.baseball.domain.Player;
import com.example.baseball.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/players") // ①
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) { // ②
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
    public String edit(@PathVariable Long id, Model model) { // ⑤
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
    public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "players/new";
        playerService.save(player);
        return "redirect:/players"; // ⑦
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