package com.task22.RestService.service;

import java.util.List;

import com.task22.RestService.pojo.Customer;

public interface CustomerServ {
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(int id);
	boolean updateCustomer(Customer customer);
	Customer loadCustomer(int id);
	List<Customer> getCustomers();
	void getMonthlySales();
}
