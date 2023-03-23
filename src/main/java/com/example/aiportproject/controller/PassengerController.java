package com.example.aiportproject.controller;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.entity.Passenger;
import com.example.aiportproject.service.AirportService;
import com.example.aiportproject.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @PostMapping("/")
    public void createPassenger(@RequestBody Passenger passenger) {
        passengerService.createPassenger(passenger);
    }

    @PutMapping("/{id}")
    public void updatePassengerDetails(@PathVariable Long id, @RequestBody Passenger passenger) {
        passengerService.updatePassengerDetails(id, passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassanger(id);
    }
}


