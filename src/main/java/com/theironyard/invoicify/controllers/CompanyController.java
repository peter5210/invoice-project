package com.theironyard.invoicify.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.Company;
import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.CompanyRepository;
import com.theironyard.invoicify.repositories.InvoiceRepository;

@Controller
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyRepository companyRepo;
	private InvoiceRepository invoiceRepo;
	
	public CompanyController(CompanyRepository companyRepo, InvoiceRepository invoiceRepo) {
		this.companyRepo = companyRepo;
		this.invoiceRepo = invoiceRepo;
	}
	
	
	@GetMapping("")
	public ModelAndView listCompanies(Authentication auth) {
		User user = (User) auth.getPrincipal();
		ModelAndView mv = new ModelAndView("companies/list");
		mv.addObject("user", user);
		mv.addObject("companies", companyRepo.findAll(new Sort(Sort.Direction.ASC, "name")));
//		mv.addObject("numberOfInvoices", companyRepo.count(invoices);
		return mv;
	}
	
	@PostMapping("create")
	public ModelAndView create(Company company) {
		companyRepo.save(company);
		return new ModelAndView ("redirect:/companies");
	}
 
}
