package com.digi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.dao.CustomerDao;
import com.digi.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
private CustomerDao customerDao;
	public void registerCustomer(Customer customer) {
		customerDao.registerCustomer(customer);
	}

}

