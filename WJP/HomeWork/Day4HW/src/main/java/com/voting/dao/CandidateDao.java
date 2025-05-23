package com.voting.dao;

import java.util.List;
import java.util.Map;

import com.voting.pojos.Candidate;

public interface CandidateDao {
    List<Candidate> getAllCandidates() throws Exception;
    void incrementVotes(int candidateId) throws Exception;
    List<Candidate> getTop2Candidates() throws Exception;
    Map<String, Integer> getPartyVotes() throws Exception;
}
