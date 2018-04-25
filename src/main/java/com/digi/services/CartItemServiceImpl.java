package com.digi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digi.dao.CartItemDao;
import com.digi.model.CartItem;
import com.digi.model.CustomerOrder;
import com.digi.model.User;
@Service

public class CartItemServiceImpl implements CartItemService{
	@Autowired
private CartItemDao cartItemDao;
	public void saveOrUpdateCartItem(CartItem cartItem) {
		cartItemDao.saveOrUpdateCartItem(cartItem);
		
	}

	public void removeCartItem(int cartItemId) {
		cartItemDao.removeCartItem(cartItemId);
	}
   
	public User getUser(String email) {
		return cartItemDao.getUser(email);
	}

	public CustomerOrder createOrder(User user) {
		return cartItemDao.createOrder(user);
	}

}