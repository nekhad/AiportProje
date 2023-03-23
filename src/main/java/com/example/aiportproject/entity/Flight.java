package com.example.aiportproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @Column(name = "departure_date")
    private String departureDate;

    @Column(name = "arrival_date")
    private String arrivalDate;

    @Column(name = "available_seats")
    private int availableSeats;

    @JoinColumn(name = "departure_airport_id",referencedColumnName = "id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport departureAirport;

    @JoinColumn(name = "arrival_airport_id",referencedColumnName = "id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Airport arrivalAirport;


    @OneToMany(mappedBy = "flight")
    Collection<Ticket> ticketCollection;


}
