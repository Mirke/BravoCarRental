package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;

/**
 * <code>CustomerService</code> - Service methods for customer entities
 * @authors Jessica
 * @version 0.0.1
 */

@Service
public class CustomerService implements ICustomerService {
    
    ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(CustomerDto dto) {
        customerRepository.save(ObjectMapper.ConvertToCustomerEntity(dto));
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return ObjectMapper.ConvertToCustomerDto(customerRepository.findById(id).get());
    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        Customer customer = customerRepository.findById(dto.getId()).get();
        customerRepository.save(ObjectMapper.ConvertToCustomerEntity(customer, dto));
    }

    @Override
    public void RemoveCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
