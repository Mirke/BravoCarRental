package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.List;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;

/**
 * <code>ICustomerService</code> - Interface for customer service  methods
 * @authors Jessica
 * @version 0.0.1
 */

public interface ICustomerService {

    void addCustomer(CustomerDto dto);

    List<Customer> getCustomers();

    CustomerDto getCustomer(Long id);

    void updateCustomer(CustomerDto dto);

    void RemoveCustomer(Long id);
}
