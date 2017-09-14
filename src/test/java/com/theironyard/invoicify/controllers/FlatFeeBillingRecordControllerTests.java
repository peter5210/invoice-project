package com.theironyard.invoicify.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.BillingRecordRepository;
import com.theironyard.invoicify.repositories.CompanyRepository;

public class FlatFeeBillingRecordControllerTests {

	private BillingRecordRepository billingRepo;
	private FlatFeeBillingRecordController flatfeeController;
	private CompanyRepository companyRepo;
	private Authentication authentication;
	
	
	@Before
	public void setup() {
		User user = new User();
		billingRepo = mock(BillingRecordRepository.class);
		flatfeeController = new FlatFeeBillingRecordController();
		authentication = mock(Authentication.class);
		when(authentication.getPrincipal()).thenReturn(user);
	}
	
	@Test
	public void test_flat_free_contoller_add_to_list() {
		
	}

}
