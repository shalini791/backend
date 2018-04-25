package com.digi.services;
import java.util.List;

import com.digi.model.Category;
import com.digi.model.Product;
public interface ProductService {
	List<Product> getAllProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
	void saveProduct(Product product);
	void updateProduct(Product product);
	List<Category> getAllCategories();
}
