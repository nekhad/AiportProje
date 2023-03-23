package com.example.aiportproject.controller;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping("/")
    public void createAirport(@RequestBody Airport airport) {
        airportService.createAirport(airport);
    }

    @PutMapping("/{id}")
    public void updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}

