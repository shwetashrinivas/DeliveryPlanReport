package com.shwetashrinivas.e2open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shwetashrinivas.e2open.entity.DeliveryPlan;
import com.shwetashrinivas.e2open.repository.DeliveryPlanRepository;
import com.shwetashrinivas.e2open.service.DPServiceImpl;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/deliveryPlan")
@RestController
public class DPController {

	@Autowired
	DPServiceImpl dpService;

	@Autowired
	DeliveryPlanRepository deliveryPlanReportRepository;

	@RequestMapping(value = "/search/{filter}/{criteria}", method = RequestMethod.GET)
	public ResponseEntity<?> searchDP(@PathVariable("filter") final String filter,
			@PathVariable("criteria") final String criteria) {
		List<DeliveryPlan> dpr = null;
		if (filter.equalsIgnoreCase("part")) {
			dpr = deliveryPlanReportRepository.findByPart(criteria);

		} else if (filter.equalsIgnoreCase("depot")) {
			dpr = deliveryPlanReportRepository.findByDepot(criteria);

		} else if (filter.equalsIgnoreCase("customer")) {
			dpr = deliveryPlanReportRepository.findByCustomer(criteria);

		}
		return new ResponseEntity<>(dpr, HttpStatus.OK);
	}

	@GetMapping("/sort/{term}")
	public ResponseEntity<?> sortDP(@PathVariable final String term) {
		List<DeliveryPlan> dpReport = null;
		if (term.equalsIgnoreCase("customer")) {
			dpReport = deliveryPlanReportRepository.findByOrderByCustomerAsc(term);

		}
		return new ResponseEntity<>(dpReport, HttpStatus.OK);
	}
}
