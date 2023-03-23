package com.example.aiportproject.controller;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.entity.Flight;
import com.example.aiportproject.service.AirportService;
import com.example.aiportproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping("/a")
    public void createFlight(@RequestBody Flight flight) {
        flightService.createFlight(flight);
    }

    @PutMapping("/{id}")
    public void updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deletFlight(id);
    }
}

