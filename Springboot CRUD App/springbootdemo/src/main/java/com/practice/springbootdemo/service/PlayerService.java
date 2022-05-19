package com.practice.springbootdemo.service;

import com.practice.springbootdemo.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    void addPlayer(Player player);
    List<Player> getAllPlayers();
    Optional<Player> getPlayerById(Long id);
    void updateRatingById(Long id,Integer newRating);
    void deletePlayerById(Long id);
}
