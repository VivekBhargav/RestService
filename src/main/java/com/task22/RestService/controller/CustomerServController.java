package com.task22.RestService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task22.RestService.pojo.Customer;
import com.task22.RestService.service.CustomerServ;

@RestController
@RequestMapping("/customer")
public class CustomerServController {

	@Autowired
	CustomerServ custServ;

	@RequestMapping(value = "/{custId}", method = RequestMethod.GET)
	public Customer loadCustomer(@PathVariable("custId") int id) {
		return custServ.loadCustomer(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		boolean status = custServ.addCustomer(customer);
		return status ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		boolean status = custServ.updateCustomer(customer);
		return status ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "/{custId}", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable("custId") int id) {
		boolean status = custServ.deleteCustomer(id) ? true : false;
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCustomers() {
		List<Customer> customers = custServ.getCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
