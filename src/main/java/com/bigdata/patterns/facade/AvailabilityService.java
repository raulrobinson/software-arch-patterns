package com.bigdata.patterns.facade;

import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {
    public boolean checkAvailability(String flightId) {
        // Lógica para verificar disponibilidad
        return true;
    }
}
