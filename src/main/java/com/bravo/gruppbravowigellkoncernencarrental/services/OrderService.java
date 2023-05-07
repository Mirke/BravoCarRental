package com.bravo.gruppbravowigellkoncernencarrental.services;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.IOrderRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <code>OrdersService</code> - Service methods (CRUD) for manipulating Orders
 * 
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) Jessica
 * @version 0.0.1
 */

@Service
public class OrderService implements IOrderService {

   private final IOrderRepository orderRepository;
   private final ICarRepository carRepository;
   private final ICustomerRepository customerRepository;

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    public OrderService(IOrderRepository orderRepository, ICarRepository carRepository, ICustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        try {
            List<Orders> orders = new ArrayList<>();
            orderRepository.findAll().forEach(orders::add);
            return ObjectMapper.ConvertToOrderDtos(orders);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<OrderDto> getCustomerOrders(Long id) {
        try {
            List<Orders> orders = new ArrayList<>();
            orderRepository.getCustomerOrders(id).forEach(orders::add);
            return ObjectMapper.ConvertToOrderDtos(orders);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public OrderDto getCustomerOrder(Long id) {
        try {
            Optional<Orders> order = orderRepository.findById(id);
            if (order.isPresent()) {
                return ObjectMapper.ConvertToOrderDto(order.get());
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean addOrder(OrderDto dto) {
        try {
            Orders order = ObjectMapper.ConvertToOrderEntity(dto);
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean updateOrder(Long id, OrderDto dto) {
        try {
            Optional<Orders> order = orderRepository.findById(id);
            if (order.isPresent()) {
                orderRepository.save(ObjectMapper.ConvertToOrderEntity(order.get(), dto));
                return true;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean cancelOrder(OrderDto dto) {
        try {
            Optional<Orders> order = orderRepository.findById(dto.getId());
            if (order.isPresent()) {
                order.get().getCar().setAvailable(true);
                order.get().setCar(null);
                order.get().setCustomer(null);
                orderRepository.save(order.get());
                return true;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean removeOrder(Long id) {
        try {
            Optional<Orders> order= orderRepository.findById(id);
            if(order.isPresent())
            {
                orderRepository.deleteById(id);
                logger.info("Admin deleted order id: " + order.get().getId());
                return true;
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
