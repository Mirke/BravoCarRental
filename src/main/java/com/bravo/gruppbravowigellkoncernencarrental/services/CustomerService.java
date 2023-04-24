package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectConverter;

@Service
public class CustomerService implements ICustomerService {
    
    ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(CustomerDto dto) {
        customerRepository.save(ObjectConverter.ConvertToCustomerEntity(dto));
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return ObjectConverter.ConvertToCustomerDto(customers);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return ObjectConverter.ConvertToCustomerDto(customerRepository.findById(id).get());
    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        Customer customer = customerRepository.findById(dto.getId()).get();
        customerRepository.save(ObjectConverter.ConvertToCustomerEntity(customer, dto));
    }

    @Override
    public void RemoveCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
