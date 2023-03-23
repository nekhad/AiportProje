package com.example.aiportproject.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "price")
    private double price;
    @JoinColumn(name = "flight_id",referencedColumnName = "id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Flight flight;
    @JoinColumn(name = "passenger_id",referencedColumnName = "id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @OneToMany(mappedBy = "ticket")
    Collection<Payment> paymentCollection;
}
