package com.example.aiportproject.service;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.entity.Flight;
import com.example.aiportproject.repository.AirportRepository;
import com.example.aiportproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void updateFlight(Long id, Flight flight) {
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isPresent()) {
            flight.setId(id);
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }

    public void deletFlight(Long id) {
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isPresent()) {
            flightRepository.deleteById(id);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }
}

