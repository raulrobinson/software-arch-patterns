package com.bigdata.patterns.facade;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/facade")
@Tag(name = "Facade", description = "Facade operations")
public class FacadeController {

    private final BookingFacade bookingFacade;

    public FacadeController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @PostMapping("/book")
    @Operation(summary = "Facade Pattern", description = "Book flight using Facade Pattern")
    @Parameter(name = "flightId", description = "Flight ID", required = true, example = "FL123")
    @Parameter(name = "userId", description = "User ID", required = true, example = "USR123")
    public String bookFlight(@RequestParam String flightId,
                             @RequestParam String userId) {
        return bookingFacade.bookFlight(flightId, userId);
    }
}
