package com.task22.RestService.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task22.RestService.dao.ICustomerDAO;
import com.task22.RestService.pojo.Customer;

@Service
public class CustomerServImpl implements CustomerServ{
	static Scanner scan = new Scanner(System.in);
	
	@Autowired
	ICustomerDAO customerDao;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = customerDao.getCustomers();
		return customers;
	}

	@Override
	public Customer loadCustomer(int id) {
		Customer cust = customerDao.loadCustomer(id);
		return cust;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean status = customerDao.updateCustomer(customer);
		return status ? true : false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean status = customerDao.deleteCustomer(id) ? true : false;
		return status;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean status = customerDao.addCustomer(customer) ? true : false;
		return status;
	}
	
	@Override
	public void getMonthlySales() {
		System.out.println("Enter year: ");
		int year = scan.nextInt();
		Map<String, Double> result = customerDao.getMonthlySales(year);
		result.forEach((k,v) -> System.out.println("Month = "
                + k + ", Sales = " + v));
	}
	
}
