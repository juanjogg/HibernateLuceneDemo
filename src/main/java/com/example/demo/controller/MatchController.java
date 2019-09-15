package com.example.demo.controller;

import com.example.demo.dtomodel.MatchDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @PostMapping
    public ResponseEntity<MatchDto> addMatch(@RequestBody MatchDto matchDto){
        return null;
    }
    @GetMapping
    public ResponseEntity<String> getAllMatches(){
        String response = "Here you go!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
