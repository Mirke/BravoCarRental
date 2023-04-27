package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <code>IOrdersRepository</code> - CRUD repository for Orders entities
 * @authors Mikael Eriksson
 * @version 0.0.1
 */

@Repository
public interface IOrdersRepository extends CrudRepository<Orders,Long> {
}
