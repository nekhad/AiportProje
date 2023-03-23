package com.example.aiportproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date")
    private String  paymentDate;

    @Column(name = "amount")
    private double amount;
    @JoinColumn(name = "ticket_id",referencedColumnName = "id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Ticket ticket;
}
