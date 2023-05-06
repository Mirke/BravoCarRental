package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <code>IOrdersRepository</code> - CRUD repository for Orders entities
 * 
 * @authors Jessica (Creator), Nicolina (Creator)
 * @version 0.0.1
 */

@Repository
public interface IOrderRepository extends CrudRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o WHERE o.customer.id = :customerId")
    List<Orders> getCustomerOrders(@Param("customerId") Long customerId);
}
