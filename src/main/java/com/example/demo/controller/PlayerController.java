package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.repo.PlayerRepo;
import com.example.demo.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private HibernateSearchService hibernateSearchService;

    @GetMapping
    public List<Player> findAllPlayers(){
        return playerRepo.findAll();

    }

    @GetMapping("/name")
    public List findPlayerByName(@RequestParam(name = "name") String name){
        return hibernateSearchService.searchPlayerByName(name);
    }
}
