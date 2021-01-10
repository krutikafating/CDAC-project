package com.eauction.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.eauction.model.Product;

public class ProductDAO  {
    private Session currentSession;
    
    private Transaction currentTransaction; 
	
    public ProductDAO() {
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
 
    public void persist(Product entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Product entity) {
        getCurrentSession().update(entity);
    }
 
    public Product findById(String id) {
        Product product = (Product) getCurrentSession().get(Product.class, id);
        return product; 
    }
 

 
    public void delete(Product entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Product> findAllProducts() {
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();
        return products;
    }
 
    public void deleteAllProducts() {
        List<Product> entityList = findAllProducts();
        for (Product entity : entityList) {
            delete(entity);
        }
    } 
}
