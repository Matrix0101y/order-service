package com.techie.orderservice.controller;

import com.techie.orderservice.common.Payment;
import com.techie.orderservice.common.TransactionRequest;
import com.techie.orderservice.common.TransactionResponse;
import com.techie.orderservice.entity.Order;
import com.techie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return orderService.saveOrder(request);
    }
}
