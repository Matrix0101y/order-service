package com.techie.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private int paymentId;

    private String paymentStatus;

    private String transactionId;

    private int orderId;

    private double amount;
}
