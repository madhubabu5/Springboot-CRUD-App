package com.practice.springbootdemo.repository;

import com.practice.springbootdemo.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Transactional
    @Modifying
    @Query("update players p set p.rating = :rating where p.id = :id")
    void setRating(@Param("rating")Integer rating,@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("delete from players p where p.id = :id")
    void deletePlayerById(@Param("id") Long id);
}
