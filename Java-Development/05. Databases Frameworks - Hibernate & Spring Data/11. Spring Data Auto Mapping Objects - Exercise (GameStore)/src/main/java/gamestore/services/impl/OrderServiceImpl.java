package gamestore.services.impl;

import gamestore.entities.Order;
import gamestore.repositories.OrderRepository;
import gamestore.services.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) {
        this.orderRepository.save(order);
    }
}
