package com.study.dao.impl;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract  class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        session.setFlushMode(FlushMode.ALWAYS);
        return session;
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void save(Object entity) {
        getSession().save(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public void refresh(Object object) {
        getSession().refresh(object);
    }
}
