package com.practice.springbootdemo.service;

import com.practice.springbootdemo.Player;
import com.practice.springbootdemo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void addPlayer(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> allPlayers = playerRepository.findAll();
        return allPlayers;
    }

    @Override
    public Optional<Player> getPlayerById(Long id) {
        Optional<Player> p = playerRepository.findById(id);
        return p;
    }

    @Override
    public void updateRatingById(Long id,Integer newRating) {
        playerRepository.setRating(newRating,id);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deletePlayerById(id);
    }
}
