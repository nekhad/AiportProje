package com.example.aiportproject.service;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.entity.Passenger;
import com.example.aiportproject.repository.AirportRepository;
import com.example.aiportproject.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public void createPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public void updatePassengerDetails(Long id, Passenger passenger) {
        Optional<Passenger> existingPassenger = passengerRepository.findById(id);
        if (existingPassenger.isPresent()) {
            passenger.setId(id);
            passengerRepository.save(passenger);
        } else {
            throw new RuntimeException("Passenger not found");
        }
    }

    public void deletePassanger(Long id) {
        Optional<Passenger> existingPassenger = passengerRepository.findById(id);
        if (existingPassenger.isPresent()) {
            passengerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Passenger not found");
        }
    }
}
