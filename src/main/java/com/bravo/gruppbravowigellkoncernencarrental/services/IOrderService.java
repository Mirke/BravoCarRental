package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;

import java.util.List;

/**
 * <code>IOrdersService</code> - Interface for Orders, service methods
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

public interface IOrderService {

    List<Orders> getAllOrders();
    List<Orders> getCustomerOrders(Long id);
    void addOrder(OrderDto dto);
    void updateOrder(Long id,OrderDto dto);
    void cancelOrder(Long id);
    void removeOrder(Long id);
    Orders getCustomerOrder(Long id);
}
