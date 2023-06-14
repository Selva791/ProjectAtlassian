package com.algorithm;

import com.alogrithm.Ballot;
import com.alogrithm.CandidateVoteServiceTask;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CandidateVoteServiceTaskTest {

    @Test
    public void testCountOfVotes(){
        // input:
        // Ballot1: A, B, C
        // Ballot2: C, B
        // Ballot3: A, E, C
        // Tie condition;
        // getResult(List<Balot> balots);
        // String
        // A, C, B, E
        CandidateVoteServiceTask candidateVoteServiceTask =new CandidateVoteServiceTask();
        List<Ballot> inputBallot =new ArrayList<>();
        List<String> candidate1 = List.of("A","B","C");
        List<String> candidate2 = List.of("C","B");
        List<String> candidate3 = List.of("A","E","C");
        inputBallot.add(new Ballot(candidate1));
        inputBallot.add(new Ballot(candidate2));
        inputBallot.add(new Ballot(candidate3));
        candidateVoteServiceTask.getResults(inputBallot);
        List<String> resultVote= candidateVoteServiceTask.getResults(inputBallot);
        Assert.assertArrayEquals(new String[]{"A","C","B","E"},resultVote.toArray());
    }
    @Test
    public void testCountOfVotesWithError(){
        CandidateVoteServiceTask candidateVoteServiceTask =new CandidateVoteServiceTask();
        List<Ballot> inputBallot =new ArrayList<>();
        List<String> candidate1 = List.of("A","B","C");
        List<String> candidate2 = List.of("","B");
        List<String> candidate3 = List.of("A","E","C");
        inputBallot.add(new Ballot(candidate1));
        inputBallot.add(new Ballot(candidate2));
        inputBallot.add(new Ballot(candidate3));
        List<String> resultVote= candidateVoteServiceTask.getResults(inputBallot);
        Assert.assertArrayEquals(new String[]{"A","B","C","E"},resultVote.toArray());
    }
}
