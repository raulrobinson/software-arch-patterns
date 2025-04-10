package com.bigdata.patterns.facade;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    public String reserveSeat(String flightId, String userId) {
        return "Asiento reservado para " + userId + " en el vuelo " + flightId;
    }
}