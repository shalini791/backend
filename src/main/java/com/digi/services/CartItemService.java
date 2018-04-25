package com.digi.services;

import com.digi.model.CartItem;
import com.digi.model.CustomerOrder;
import com.digi.model.User;

public interface CartItemService {
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int cartItemId);
	User getUser(String email);
	CustomerOrder createOrder(User user);
}

