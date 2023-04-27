package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;

import java.util.List;

/**
 * <code>IOrdersService</code> - Interface for Orders, service methods
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

public interface IOrdersService {

    List<Orders> getAllOrders();
    List<Orders> getCustomerOrders(Long id);
    void orderCar(Long id);
    void cancelOrder(Long id);
    void removeOrder(Long id);
}
