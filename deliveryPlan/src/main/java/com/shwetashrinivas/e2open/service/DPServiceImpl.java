package com.shwetashrinivas.e2open.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.shwetashrinivas.e2open.entity.DeliveryPlan;
import com.shwetashrinivas.e2open.repository.DeliveryPlanRepository;

@Service
public class DPServiceImpl{

    @Autowired
    DeliveryPlanRepository deliveryPlanReportRepository;    
    
    public List<DeliveryPlan> findByPart(String part){
    	return deliveryPlanReportRepository.findByPart(part);
    }

    public List<DeliveryPlan> findByDepot(String depot){
		return deliveryPlanReportRepository.findByDepot(depot);
	}

    public List<DeliveryPlan> findByCustomer(String customer){
		return deliveryPlanReportRepository.findByCustomer(customer);
	}

    public List<DeliveryPlan> findByDueDateBefore(LocalDate dueDate){
		return deliveryPlanReportRepository.findByDueDateBefore(dueDate);
	}

    public List<DeliveryPlan> findByOrderByCustomerAsc(String customer){
		return deliveryPlanReportRepository.findByOrderByCustomerAsc(customer);	
	}

    public List<DeliveryPlan> findByCustomerOrderByQuantityAsc(String customer){
		return deliveryPlanReportRepository.findByCustomerOrderByQuantityAsc(customer);
	}
	
	public List<DeliveryPlan> findAll() {
		return deliveryPlanReportRepository.findAll();
	}

	public Page<DeliveryPlan> findPaginated(int page, int size) {
		Pageable pageWithSizeElements = PageRequest.of(page, size);
		Page<DeliveryPlan> all = deliveryPlanReportRepository.findAll(pageWithSizeElements);

		return all;
	}

}
