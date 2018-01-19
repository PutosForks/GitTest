package com.example.mfe.service;


import com.example.mfe.domain.Player;
import com.example.mfe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> findall() {
        return playerRepository.findAll();
    }

    public Player findOne(Long id) {
        return playerRepository.findOne(id);
    }


    @ExceptionHandler(PlayerExceptionClass.class)
    public Player save(Player player) {
        if (player.getAge() < 2) {
            throw new PlayerExceptionClass("Kids don't work!");
        }
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.delete(id);
    }



}
