package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PageDao;
import com.dao.PageDaoImpl;
import com.model.Product;

public class PageServiceImpl implements PageService {
	PageDao pageDao =new PageDaoImpl();
	@Override
	public List<Product> getRecentProducts()  {
		List<Product> poducts=pageDao.getRecentProducts();
		return poducts;
	}
	
	@Override
	public byte[] getImages(String imageId) throws SQLException {
		byte[] blobAsBytes = pageDao.getImages(imageId);
		return blobAsBytes;

	}
	@Override
	public List<Product> viewProduct(String productID){
		List<Product> product=pageDao.viewProduct(productID);
		return product;
		
	}

	@Override
	public void addCartProduct(String userId, String productId) {
		pageDao.addCartProduct(userId, productId);
		
	}
}
