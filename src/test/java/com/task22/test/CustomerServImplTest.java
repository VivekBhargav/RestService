package com.task22.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.task22.RestService.dao.ICustomerDAO;
import com.task22.RestService.pojo.Customer;
import com.task22.RestService.service.CustomerServ;
import com.task22.RestService.service.CustomerServImpl;

@RunWith(SpringRunner.class)
public class CustomerServImplTest {
	
    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerServ customerService() {
            return new CustomerServImpl();
        }
    }
    
    @Autowired
	CustomerServ custServ;
	
	@MockBean
	ICustomerDAO customerDao;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	
	@Test
	public void testLoadCustomer()
	{
		Mockito.when(customerDao.loadCustomer(500)).thenReturn(getCustomer());
		Customer cust = custServ.loadCustomer(500);
		assertEquals(getCustomer().toString(), cust.toString());
	}
	
	@Test
	public void testCreateCustomer() {
		Customer cust = getCustomer();
		Mockito.when(customerDao.addCustomer(cust)).thenReturn(true);
		assertTrue(custServ.addCustomer(cust));
	}
	
	public void testUpdateCustomer() {
		Customer cust = getCustomer();
		Mockito.when(customerDao.updateCustomer(cust)).thenReturn(true);
		assertTrue(custServ.updateCustomer(cust));
	}
	
	private Customer getCustomer() {
		return new Customer("mr","test","lastName","test@test.com","TestCompany","TEstanme");
	}

}
