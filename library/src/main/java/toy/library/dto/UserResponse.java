package toy.library.dto;

import lombok.Getter;
import lombok.Setter;
import toy.library.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResponse {
    private String username;
    List<RentalResponse> rentals;

    public UserResponse(User user) {
        username = username;
        rentals = user.getRentals().stream()
                .map(o -> new RentalResponse(o))
                .collect(Collectors.toList());
    }
}
