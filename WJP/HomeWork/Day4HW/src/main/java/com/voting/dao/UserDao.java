package com.voting.dao;

import com.voting.pojos.User;

public interface UserDao {
    User authenticateUser(String email, String password) throws Exception;
    void updateVotingStatus(int userId) throws Exception;
}