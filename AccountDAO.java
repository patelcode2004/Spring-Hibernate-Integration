package com.example.app.dao;

import com.example.app.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccount(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void updateAccount(Account acc) {
        sessionFactory.getCurrentSession().update(acc);
    }
}
