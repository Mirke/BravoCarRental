package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.controllers.CustomerController;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.IOrderRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>OrdersService</code> - Service methods (CRUD) for manipulating Orders
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) /  Jessica
 * @version 0.0.1
 */

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    ICarRepository iCarRepository;

    @Autowired
    ICustomerRepository iCustomerRepository;

    private static final Logger logger = LogManager.getLogger(OrderService.class);

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
        Car car = iCarRepository.findById(order.getCar().getId()).get();
        Customer customer = iCustomerRepository.findById(order.getCustomer().getId()).get();
        car.setAvailable(false);
        order.setCar(car);
        logger.info("Customer "+ customer.getFirstName() + " ordered car " + order.getCar().getFactory() + " " + order.getCar().getModel());
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, OrderDto dto) {
       orderRepository.save(
        ObjectMapper.ConvertToOrderEntity(
            orderRepository.findById(id).get(), dto));

    }

    @Override
    public void cancelOrder(OrderDto dto) {
        Orders orders1 = orderRepository.findById(dto.getId()).get();
        orders1.getCar().setAvailable(true);

        orders1.setCar(null);
        orders1.setCustomer(null);

        orderRepository.save(orders1);

    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

 
}
