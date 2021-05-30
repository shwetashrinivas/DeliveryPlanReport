package com.shwetashrinivas.e2open.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shwetashrinivas.e2open.entity.DeliveryPlan;
import com.shwetashrinivas.e2open.repository.DeliveryPlanRepository;

@Service
public class DPServiceImpl{

    @Autowired
    DeliveryPlanRepository deliveryPlanReportRepository;    
    
    List<DeliveryPlan> findByPart(String part){
    	return deliveryPlanReportRepository.findByPart(part);
    }

	List<DeliveryPlan> findByDepot(String depot){
		return deliveryPlanReportRepository.findByDepot(depot);
	}

	List<DeliveryPlan> findByCustomer(String customer){
		return deliveryPlanReportRepository.findByCustomer(customer);
	}

	List<DeliveryPlan> findByDueDateBefore(LocalDate dueDate){
		return deliveryPlanReportRepository.findByDueDateBefore(dueDate);
	}

	List<DeliveryPlan> findByOrderByCustomerAsc(String customer){
		return deliveryPlanReportRepository.findByOrderByCustomerAsc(customer);	
	}

	List<DeliveryPlan> findByCustomerOrderByQuantityAsc(String customer){
		return deliveryPlanReportRepository.findByCustomerOrderByQuantityAsc(customer);
	}
}
