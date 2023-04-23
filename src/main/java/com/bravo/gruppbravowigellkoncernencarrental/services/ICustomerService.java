package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.List;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;

public interface ICustomerService {

    void addCustomer(CustomerDto dto);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomer(Long id);

    void updateCustomer(CustomerDto dto);

    void RemoveCustomer(Long id);
}
