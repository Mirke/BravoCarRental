package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.IOrderRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>OrdersService</code> - Service methods (CRUD) for manipulating Orders
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) Jessica lloyd (jessica.lloyd@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class OrderService implements IOrderService {

    IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public List<Orders> getCustomerOrders(Long id) {
        List<Orders> orders = new ArrayList<>();
        orderRepository.getCustomerOrders(id).forEach(orders::add);
        return orders;
    }

    @Override
    public Orders getCustomerOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void addOrder(OrderDto dto) {
        Orders order = ObjectMapper.ConvertToOrderEntity(dto);
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, OrderDto dto) {
       orderRepository.save(
        ObjectMapper.ConvertToOrderEntity(
            orderRepository.findById(id).get(), dto));

    }

    // TODO - Method for when a Customer decides to cancel and order
    @Override
    // TODO - We need to add a flag-property to identify if the order is active or not. this method is based on that prop. 
    public void cancelOrder(Long id) {

    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

 
}
