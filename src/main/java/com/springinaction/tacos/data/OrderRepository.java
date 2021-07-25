package com.springinaction.tacos.data;

import com.springinaction.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
