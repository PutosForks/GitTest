package com.example.baseball.service;


import com.example.baseball.domain.Player;
import com.example.baseball.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.delete(id);
    }


}
