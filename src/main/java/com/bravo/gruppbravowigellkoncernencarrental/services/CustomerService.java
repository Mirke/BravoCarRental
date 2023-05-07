package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * <code>CustomerService</code> - Service methods for customer entities
 * 
 * @authors Jessica
 * @version 0.0.1
 */

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private static final Logger logger = LogManager.getLogger(CustomerService.class);

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean addCustomer(CustomerDto dto) {
        try {
            customerRepository.save(ObjectMapper.ConvertToCustomerEntity(dto));
            logger.info("Admin added new customer " + dto.getFirstName() + " " + dto.getLastName());
            return true;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public List<Customer> getCustomers() {
        try {
            List<Customer> customers = new ArrayList<>();
            customerRepository.findAll().forEach(customers::add);
            return customers;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;

    }

    @Override
    public CustomerDto getCustomer(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if (customer.isPresent()) {
                return ObjectMapper.ConvertToCustomerDto(customer.get());
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) {
        try {
            Optional<Customer> customer = customerRepository.findById(dto.getId());
            if (customer.isPresent()) {
                customerRepository.save(ObjectMapper.ConvertToCustomerEntity(customer.get(), dto));
                logger.info("Admin updated customer " + customer.get().getFirstName() + " "
                + customer.get().getLastName() + " to " + dto.getFirstName() + " "
                + dto.getLastName());
                return true;
            }
        } catch (Exception e) {
            logger.error("Admin couldn't update customer with id: " + dto.getId());
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean RemoveCustomer(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if(customer.isPresent()){
                customerRepository.deleteById(customer.get().getId());
                logger.info("Admin deleted customer " + customer.get().getFirstName() + " "
                    + customer.get().getLastName());
                return true;
            }
        } catch (Exception e) {
            logger.error("Admin couldn't delete customer with id: " + id);
            logger.error(e);
        }
        return false;
    }

}
