package com.alogrithm;

import java.util.*;

public class CandidateVoteServiceTask implements VoteCounter{

    Map<String,Integer> candidateVoteCounter;
    public CandidateVoteServiceTask(){
        candidateVoteCounter = new HashMap<>();
    }
    @Override
    public List<String> getResults(List<Ballot> ballots) {
        int sizeOfBallot = ballots.size();

            for(int i=0;i<sizeOfBallot;i++){
                Ballot ballot = ballots.get(i);
                List<String> candidateList = ballot.getCandidate();
                int vote=3;
                for(int j=0;j<candidateList.size();j++){
                        if(candidateList.get(j).equals("")){
                            System.out.println("Empty Vote for Ballot: "+ i);
                            continue;
                        }
                        candidateVoteCounter
                                .put(candidateList.get(j),candidateVoteCounter.getOrDefault(candidateList.get(j),0)+vote);
                        vote--;
                }
            }

            PriorityQueue<Map.Entry<String,Integer>> sortVoteByCandidate = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
            sortVoteByCandidate.addAll(candidateVoteCounter.entrySet());

            List<String> resultOfVoteCount = new ArrayList<>();

            while (!sortVoteByCandidate.isEmpty()){
                resultOfVoteCount.add(sortVoteByCandidate.poll().getKey());
            }

        return resultOfVoteCount;
    }
}
