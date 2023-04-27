package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>OrdersService</code> - Service methods (CRUD) for manipulating Orders
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    IOrdersRepository iOrdersRepository;

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        iOrdersRepository.findAll().forEach(orders::add);
        return orders;
    }

    // TODO - Needs to get all of the orders made by a customer

    @Override
    public List<Orders> getCustomerOrders(Long id) {
        return null;
    }

    // TODO - Method for a Customer when they order a car that is available

    @Override
    public void orderCar(Long id) {

    }

    // TODO - Method for when a Customer decides to cancel and order

    @Override
    public void cancelOrder(Long id) {

    }

    // TODO - Method for when an Admin decides to remove an order from repository
    @Override
    public void removeOrder(Long id) {

    }
}
