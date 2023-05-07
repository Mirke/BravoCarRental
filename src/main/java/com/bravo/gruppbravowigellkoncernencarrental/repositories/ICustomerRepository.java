package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;

/**
 * <code>ICustomerRepository</code> - Crud repository for Customer entities
 * @authors Jessica
 * @version 0.0.1
 */


@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {
}
