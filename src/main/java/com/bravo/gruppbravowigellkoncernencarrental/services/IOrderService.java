package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;

import java.util.List;

/**
 * <code>IOrdersService</code> - Interface for Orders, service methods
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) Jessica
 * @version 0.0.1
 */

public interface IOrderService {

    List<OrderDto> getAllOrders();
    List<OrderDto> getCustomerOrders(Long id);
    boolean addOrder(OrderDto dto);
    boolean updateOrder(Long id,OrderDto dto);
    boolean cancelOrder(OrderDto dto);
    boolean removeOrder(Long id);
    OrderDto getCustomerOrder(Long id);
}
