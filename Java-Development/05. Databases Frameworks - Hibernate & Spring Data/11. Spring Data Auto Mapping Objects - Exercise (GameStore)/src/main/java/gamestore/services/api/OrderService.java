package gamestore.services.api;

import gamestore.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void add(Order order);
}
