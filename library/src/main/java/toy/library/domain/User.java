package toy.library.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Library_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private int countRental;

    private int countAble;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals = new ArrayList<>();

}
