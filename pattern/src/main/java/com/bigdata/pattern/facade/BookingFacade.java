package com.bigdata.pattern.facade;

import org.springframework.stereotype.Component;

@Component
public class BookingFacade {

    private final AvailabilityService availabilityService;
    private final ReservationService reservationService;
    private final NotificationService notificationService;

    public BookingFacade(AvailabilityService availabilityService,
                         ReservationService reservationService,
                         NotificationService notificationService) {
        this.availabilityService = availabilityService;
        this.reservationService = reservationService;
        this.notificationService = notificationService;
    }

    public String bookFlight(String flightId, String userId) {
        if (!availabilityService.checkAvailability(flightId)) {
            return "No hay asientos disponibles";
        }

        String reservation = reservationService.reserveSeat(flightId, userId);
        notificationService.notifyUser(userId, reservation);

        return reservation;
    }
}
