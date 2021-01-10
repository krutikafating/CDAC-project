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
 
    public Product findById(String id) {
        productDao.openCurrentSession();
        Product product = productDao.findById(id);
        productDao.closeCurrentSession();
        return product;
    }
 
    
    public void delete(String id) {
        productDao.openCurrentSessionwithTransaction();
        Product product = productDao.findById(id);
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
