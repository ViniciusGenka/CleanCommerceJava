package com.genka.cleancommerce.domain.order;

import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.order.enums.OrderStatus;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private UUID customerId;
    private Address destinationAddress;
    private List<OrderItem> items;
    private OrderStatus status;
}
