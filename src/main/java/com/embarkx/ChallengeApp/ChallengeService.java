package com.embarkx.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextid = 1L;

    public ChallengeService(){
//        Challenge challenge1 =
//                new Challenge(1L, "January", "Learn a new Programming language");
//        challenges.add(challenge1);
    }
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenges(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextid++);
            challenges.add(challenge);
            return true;
        } else {
            return false;

        }
    }

    public Challenge getChallenge(String month) {
        for(Challenge challenge: challenges){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {

        for(Challenge challenge: challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }

            }
        return false;

    }

    public boolean deleteChallengs(Long id) {
 return challenges.removeIf(challenge -> challenge.getId().equals(id));




    }
}
