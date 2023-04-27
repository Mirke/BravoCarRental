package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 * <code>IOrdersRepository</code> - CRUD repository for Orders entities
 * @authors Mikael Eriksson
 * @version 0.0.1
 */

public interface IOrdersRepository extends CrudRepository<Orders,Long> {
}
