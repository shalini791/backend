package com.digi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digi.model.Authorities;
import com.digi.model.Cart;
import com.digi.model.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer){
		//all objects are transient
		Session session=sessionFactory.getCurrentSession();
		//create authorities
		//create cart
		//set enabled as true
		customer.getUser().setEnabled(true);
		
		Authorities authorities=new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());//FK user_email in authroities table
		customer.getUser().setAuthorities(authorities);
		
		Cart cart=new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		session.save(customer);//persistent
	}
//all objects are detached
}

