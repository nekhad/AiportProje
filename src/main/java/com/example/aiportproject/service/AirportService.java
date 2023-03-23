package com.example.aiportproject.service;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void updateAirport(Long id, Airport airport) {
        Optional<Airport> existingAirport = airportRepository.findById(id);
        if (existingAirport.isPresent()) {
            airport.setId(id);
            airportRepository.save(airport);
        } else {
            throw new RuntimeException("Airport not found");
        }
    }

    public void deleteAirport(Long id) {
        Optional<Airport> existingAirport = airportRepository.findById(id);
        if (existingAirport.isPresent()) {
            airportRepository.deleteById(id);
        } else {
            throw new RuntimeException("Airport not found");
        }
    }
}
