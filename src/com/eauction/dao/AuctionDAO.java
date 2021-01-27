package com.eauction.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.eauction.model.Auction;

public class AuctionDAO  {
    private Session currentSession;
    
    private Transaction currentTransaction; 
	
    public AuctionDAO() {
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
 
    public void persist(Auction entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Auction entity) {
        getCurrentSession().update(entity);
    }
 
    public Auction findById(int id) {
        Auction auction = (Auction) getCurrentSession().get(Auction.class, id);
        return auction; 
    }
    
    public List<Auction>  findAllAuctionsdBySellerId(int id) {
    	List<Auction> auctions = (List<Auction>) getCurrentSession().createQuery(String.format("FROM Auction where seller_id = %d", id)).list();
        return auctions; 
    }
 
    public List<Auction>  findAllAuctionsdBySellerIdAndProductId(int seller_id, int product_id) {
    	List<Auction> auctions = (List<Auction>) getCurrentSession().createQuery(String.format("FROM Auction where seller_id = %d AND product_id = %d",seller_id,product_id)).list();
        return auctions; 
    }
    
    public List<Auction> findAllProductsdByBuyerId(int id) {
    	List<Auction> auctions = (List<Auction>) getCurrentSession().createQuery(String.format("FROM Auction where buyer_id = %d", id)).list();
        return auctions; 
    }
   
    public void delete(Auction entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Auction> findAllAuctions() {
        List<Auction> auctions = (List<Auction>) getCurrentSession().createQuery("from Auction").list();
        return auctions;
    }
 
    public void deleteAllAuctions() {
        List<Auction> entityList = findAllAuctions();
        for (Auction entity : entityList) {
            delete(entity);
        }
    } 
}
