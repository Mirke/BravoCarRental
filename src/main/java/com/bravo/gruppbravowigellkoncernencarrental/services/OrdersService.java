package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <code>OrdersService</code> - Service methods (CRUD) for manipulating Orders
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class OrdersService implements IOrdersService {

    @Override
    public List<Orders> getAllOrders() {
        return null;
    }

    @Override
    public List<Orders> getCustomerOrders(Long id) {
        return null;
    }

    @Override
    public void orderCar(Long id) {

    }

    @Override
    public void cancelOrder(Long id) {

    }

    @Override
    public void removeOrder(Long id) {

    }
}
