package com.shwetashrinivas.e2open.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shwetashrinivas.e2open.entity.DeliveryPlan;

public interface DeliveryPlanRepository extends JpaRepository<DeliveryPlan, Integer> {

	List<DeliveryPlan> findByPart(String part);

	List<DeliveryPlan> findByDepot(String depot);

	List<DeliveryPlan> findByCustomer(String customer);

	List<DeliveryPlan> findByDateRange(LocalDate startDate, LocalDate endDate);

	List<DeliveryPlan> findByDueDateBefore(LocalDate dueDate);

	List<DeliveryPlan> findByOrderByCustomerAsc(String customer);

	List<DeliveryPlan> findByCustomerOrderByQuantityAsc(String customer);

}