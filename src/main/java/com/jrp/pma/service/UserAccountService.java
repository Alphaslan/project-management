package com.jrp.pma.service;

import com.jrp.pma.dao.UserAccountRepository;
import com.jrp.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    UserAccountRepository userR;

    public UserAccount save(UserAccount user) {
        return userR.save(user);
    }
}
