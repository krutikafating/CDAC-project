package com.eauction.service;

import java.util.List;

import com.eauction.dao.ProductDAO;
import com.eauction.model.Product;

public class ProductService {
    private static ProductDAO productDao;
    
    public ProductService() {
        productDao = new ProductDAO();
    }
 
    public void persist(Product entity) {
        productDao.openCurrentSessionwithTransaction();
        productDao.persist(entity);
        productDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Product entity) {
        productDao.openCurrentSessionwithTransaction();
        productDao.update(entity);
        productDao.closeCurrentSessionwithTransaction();
    }
 
    public Product findById(int id) {
        productDao.openCurrentSession();
        Product product = productDao.findById(id);
        productDao.closeCurrentSession();
        return product;
    }
 
    public List<Product> findAllProductsdBySellerId(int id) {
        productDao.openCurrentSession();
        List<Product> products = productDao.findAllProductsdBySellerId(id);
        productDao.closeCurrentSession();
        return products;
    }
    
    public List<Product> findAllProductsOtherThanSellerId(int id) {
        productDao.openCurrentSession();
        List<Product> products = productDao.findAllProductsOtherThanSellerId(id);
        productDao.closeCurrentSession();
        return products;
    }
    
    public Product getImage(int id)
    {
    	 productDao.openCurrentSession();
    	 Product item = productDao.getImage(id);
    	  productDao.closeCurrentSession();
          return item;
    }
    
    
    
    public void delete(String id) {
        productDao.openCurrentSessionwithTransaction();
        Product product = productDao.findById(Integer.parseInt(id));
        productDao.delete(product);
        productDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Product> findAll() {
        productDao.openCurrentSession();
        List<Product> products = productDao.findAllProducts();
        productDao.closeCurrentSession();
        return products;
    }
 
    public void deleteAll() {
        productDao.openCurrentSessionwithTransaction();
        productDao.deleteAllProducts();
        productDao.closeCurrentSessionwithTransaction();
    }
 
    public ProductDAO productDao() {
        return productDao;
    }
}
