package com.eauction.service;

import java.util.List;

import com.eauction.dao.AuctionDAO;
import com.eauction.model.Auction;

public class AuctionService {
    private static AuctionDAO auctionDao;
    
    public AuctionService() {
        auctionDao = new AuctionDAO();
    }
 
    public void persist(Auction entity) {
        auctionDao.openCurrentSessionwithTransaction();
        auctionDao.persist(entity);
        auctionDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Auction entity) {
        auctionDao.openCurrentSessionwithTransaction();
        auctionDao.update(entity);
        auctionDao.closeCurrentSessionwithTransaction();
    }
 
    public Auction findById(int id) {
        auctionDao.openCurrentSession();
        Auction auction = auctionDao.findById(id);
        auctionDao.closeCurrentSession();
        return auction;
    }
 
    public List<Auction> findAllAuctionsdBySellerId(int id) {
        auctionDao.openCurrentSession();
        List<Auction> auctions = auctionDao.findAllAuctionsdBySellerId(id);
        auctionDao.closeCurrentSession();
        return auctions;
    }
    
    public List<Auction> findAllAuctionsdBySellerIdAndProductId(int seller_id, int product_id) {
        auctionDao.openCurrentSession();
        List<Auction> auctions = auctionDao.findAllAuctionsdBySellerIdAndProductId(seller_id,product_id);
        auctionDao.closeCurrentSession();
        return auctions;
    }
    
    public List<Auction> findAllProductsdByBuyerId(int id) {
        auctionDao.openCurrentSession();
        List<Auction> auctions = auctionDao.findAllProductsdByBuyerId(id);
        auctionDao.closeCurrentSession();
        return auctions;
    }
    
    
    
    
    
    public void delete(String id) {
        auctionDao.openCurrentSessionwithTransaction();
        Auction auction = auctionDao.findById(Integer.parseInt(id));
        auctionDao.delete(auction);
        auctionDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Auction> findAll() {
        auctionDao.openCurrentSession();
        List<Auction> auctions = auctionDao.findAllAuctions();
        auctionDao.closeCurrentSession();
        return auctions;
    }
 
    public void deleteAll() {
        auctionDao.openCurrentSessionwithTransaction();
        auctionDao.deleteAllAuctions();
        auctionDao.closeCurrentSessionwithTransaction();
    }
 
    public AuctionDAO auctionDao() {
        return auctionDao;
    }
}
