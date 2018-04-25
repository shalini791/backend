package com.digi.dao;

import com.digi.model.CartItem;
import com.digi.model.CustomerOrder;
import com.digi.model.User;

public interface CartItemDao {
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int cartItemId);
    User getUser(String email);
	CustomerOrder createOrder(User user);
}

