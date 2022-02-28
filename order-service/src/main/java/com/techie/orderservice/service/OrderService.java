package com.techie.orderservice.service;

import com.techie.orderservice.common.Payment;
import com.techie.orderservice.common.TransactionRequest;
import com.techie.orderservice.common.TransactionResponse;
import com.techie.orderservice.entity.Order;
import com.techie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9191/api/v1/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"There is a failure in payment api, order added to cart";

            orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }


}
