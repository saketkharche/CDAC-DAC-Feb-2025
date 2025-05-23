package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.Candidate;

public interface CandidateDao {
//get all candidates
	List<Candidate> getAllCandidates() throws SQLException;
//incr votes
	String incrementCandidateVotes(int candidateId) throws SQLException;
}
