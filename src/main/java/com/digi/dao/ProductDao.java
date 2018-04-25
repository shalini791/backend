package com.digi.dao;
import java.util.List;

import com.digi.model.Category;
import com.digi.model.Product;
public interface ProductDao {

	List<Product> getAllProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
	void saveOrUpdateProduct(Product product);
	List<Category> getAllCategories();
	}
	
