package com.example.demo.repo;

import com.example.demo.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends CrudRepository<Match, Integer> {
}
