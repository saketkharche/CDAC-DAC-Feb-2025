package com.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.voting.pojos.Candidate;
import com.voting.utils.DBUtils;

public class CandidateDaoImpl implements CandidateDao {
    private Connection conn;
    private PreparedStatement pst1, pst2, pst3, pst4;

    public CandidateDaoImpl() throws Exception {
        conn = DBUtils.openConnection();
        pst1 = conn.prepareStatement("SELECT * FROM candidates");
        pst2 = conn.prepareStatement("UPDATE candidates SET votes=votes+1 WHERE id=?");
        pst3 = conn.prepareStatement("SELECT * FROM candidates ORDER BY votes DESC LIMIT 2");
        pst4 = conn.prepareStatement("SELECT party, SUM(votes) FROM candidates GROUP BY party");
    }

    public List<Candidate> getAllCandidates() throws Exception {
        List<Candidate> list = new ArrayList<>();
        ResultSet rst = pst1.executeQuery();
        while (rst.next()) {
            list.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }
        return list;
    }

    public void incrementVotes(int candidateId) throws Exception {
        pst2.setInt(1, candidateId);
        pst2.executeUpdate();
    }

    public List<Candidate> getTop2Candidates() throws Exception {
        List<Candidate> list = new ArrayList<>();
        ResultSet rst = pst3.executeQuery();
        while (rst.next()) {
            list.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }
        return list;
    }

    public Map<String, Integer> getPartyVotes() throws Exception {
        Map<String, Integer> map = new LinkedHashMap<>();
        ResultSet rst = pst4.executeQuery();
        while (rst.next()) {
            map.put(rst.getString(1), rst.getInt(2));
        }
        return map;
    }

    public void cleanUp() throws Exception {
        if (pst1 != null) pst1.close();
        if (pst2 != null) pst2.close();
        if (pst3 != null) pst3.close();
        if (pst4 != null) pst4.close();
        if (conn != null) conn.close();
    }
}
