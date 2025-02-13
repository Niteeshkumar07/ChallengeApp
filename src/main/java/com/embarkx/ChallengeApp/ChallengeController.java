package com.embarkx.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
   private ChallengeService challengesService;


    public ChallengeController(ChallengeService challengeService){
        this.challengesService = challengeService;

    }
    @GetMapping
    public ResponseEntity< List<Challenge>> getAllChallenges(){


        return new ResponseEntity<>(challengesService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
       boolean isChallengeAdded = challengesService.addChallenges(challenge);
       if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added Sucessfully",HttpStatus.OK);
       else
           return new ResponseEntity<>("Challenge not added Sucessfully",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/ {month}")
    public ResponseEntity<Challenge>  getChallenges(@PathVariable String month){
        Challenge challenge = challengesService.getChallenge(month);
        if(challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
      boolean isChallengeUpdated = challengesService.updateChallenge(id, updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated Sucessfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not updated Sucessfully",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengesService.deleteChallengs(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge deleted Sucessfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not deleted",HttpStatus.NOT_FOUND);
    }
}
