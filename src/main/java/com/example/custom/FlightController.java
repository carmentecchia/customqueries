package com.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.custom.FlightStatus.ONTIME;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    private final int numFlight = 50;

    @GetMapping("/provision")
    public Flight provisionFlights() {
        Random random = new Random();
        for (int i = 0; i < numFlight; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + random.nextInt(50));
            flight.setToAirport("Airport " + random.nextInt(50));
            flight.setFlightStatus(FlightStatus.ONTIME);

            return flightRepository.save(flight);

        }
        return null;
    }
    @GetMapping("/getAll")
    public List<String> getAllFlights() {
        return flightRepository.retrieveAllFlights();
    }
}