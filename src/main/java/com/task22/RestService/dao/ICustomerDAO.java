package com.task22.RestService.dao;

import java.util.List;
import java.util.Map;

import com.task22.RestService.pojo.Customer;


public interface ICustomerDAO {
	boolean addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(Customer customer);

	Customer loadCustomer(int customerId);
	
	List<Customer> getCustomers(); 

	Map<String, Double> getMonthlySales(int year); //get monthly sales in the given year.

}
