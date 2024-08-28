package toy.library.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.library.domain.Rental;
import toy.library.dto.RentalAllResponse;
import toy.library.dto.RentalResponse;
import toy.library.service.RentalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("/rentalList")
    public List<RentalAllResponse> rentalList(){
        List<Rental> rentals = rentalService.findRentalsAll();
        List<RentalAllResponse> rental = rentals.stream().map(o -> new RentalAllResponse(o))
                .collect(Collectors.toList());
        return rental;
    }

}
