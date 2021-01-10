package com.eauction.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;

import com.eauction.db.HibernateDatabaseConnection;
import com.eauction.model.User;

public class UserDAO   {
    private Session currentSession;
    
    private Transaction currentTransaction; 
	
    public UserDAO() {
    }
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(User entity) {
    	System.out.println(entity.getEmail());
        getCurrentSession().save(entity);
    }
 
    public void update(User entity) {
        getCurrentSession().update(entity);
    }
 
    public User findById(String id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user; 
    }
 
    public List<User> findUsersByEmail(String email) {
    	List<User> users = (List<User>) getCurrentSession().createQuery(String.format("FROM User where email='%s'", email)).list();
        return users; 
    }
 
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        List<User> users = (List<User>) getCurrentSession().createQuery("from User").list();
        return users;
    }
 
    public void deleteAll() {
        List<User> entityList = findAll();
        for (User entity : entityList) {
            delete(entity);
        }
    } 
}
