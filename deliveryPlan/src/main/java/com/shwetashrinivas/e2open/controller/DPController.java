package com.shwetashrinivas.e2open.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shwetashrinivas.e2open.entity.DeliveryPlan;
import com.shwetashrinivas.e2open.repository.DeliveryPlanRepository;
import com.shwetashrinivas.e2open.service.DPServiceImpl;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/deliveryPlan")
@RestController
public class DPController {

	DPServiceImpl dpService;	
	DeliveryPlanRepository deliveryPlanReportRepository;
	
	@Autowired
	public DPController(DPServiceImpl dpService, DeliveryPlanRepository deliveryPlanReportRepository) {
		this.dpService = dpService;
		this.deliveryPlanReportRepository = deliveryPlanReportRepository;
	}

	@GetMapping("/view")
	public ResponseEntity<?> viewDP(){
		List<DeliveryPlan> deliveryPlan = new ArrayList<DeliveryPlan>();
		deliveryPlan = dpService.findAll();
		
		if (deliveryPlan.isEmpty()) {
			return new ResponseEntity<>(deliveryPlan,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(deliveryPlan, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{filter}/{criteria}", method = RequestMethod.GET)
	public ResponseEntity<?> searchDP(@PathVariable("filter") final String filter,
			@PathVariable("criteria") final String criteria) {
		List<DeliveryPlan> dpr = null;
		if (filter.equalsIgnoreCase("part")) {
			dpr = dpService.findByPart(criteria);

		} else if (filter.equalsIgnoreCase("depot")) {
			dpr = dpService.findByDepot(criteria);

		} else if (filter.equalsIgnoreCase("customer")) {
			dpr = dpService.findByCustomer(criteria);

		}
		return new ResponseEntity<>(dpr, HttpStatus.OK);
	}

	@GetMapping("/sort/{term}")
	public ResponseEntity<?> sortDP(@PathVariable final String term) {
		List<DeliveryPlan> dpReport = null;
		if (term.equalsIgnoreCase("customer")) {
			dpReport = dpService.findByOrderByCustomerAsc(term);
		}
		return new ResponseEntity<>(dpReport, HttpStatus.OK);
	}
	
	@GetMapping(params = { "page", "size" })
	public List<DeliveryPlan> findPaginated(@RequestParam("page") int page, 
	  @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
	  HttpServletResponse response) throws Exception 
	{
	    Page<DeliveryPlan> resultPage = dpService.findPaginated(page, size);
	    if (page > resultPage.getTotalPages()) {
	        throw new Exception();
	    }
	    return resultPage.getContent();
	}
	
}
