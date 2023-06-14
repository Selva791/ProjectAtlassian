package com.alogrithm;

import java.util.List;

public class Ballot {
    private List<String> candidate;
    public Ballot(List<String> candidate){
        this.candidate = candidate;
    }

    public List<String> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<String> candidate) {
        this.candidate = candidate;
    }
}
