package com.digi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.dao.ProductDao;
import com.digi.model.Category;
import com.digi.model.Product;
@Service
public class ProductserviceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
		public List<Product> getAllProducts() {
			return productDao.getAllProducts();
		}
		public Product getProduct(int id) {
			//call dao 
			return productDao.getProduct(id);
		}
		public void deleteProduct(int id) {
			productDao.deleteProduct(id);
		}
		public void saveProduct(Product product) {
			productDao.saveOrUpdateProduct(product);
			
		}
		public void updateProduct(Product product) {
			productDao.saveOrUpdateProduct(product);
			
		}
		public List<Category> getAllCategories() {
			return productDao.getAllCategories();
		}
}
