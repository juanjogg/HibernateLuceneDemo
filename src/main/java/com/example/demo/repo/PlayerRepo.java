package com.example.demo.repo;

import com.example.demo.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Integer> {
   List<Player> findAll();
}
