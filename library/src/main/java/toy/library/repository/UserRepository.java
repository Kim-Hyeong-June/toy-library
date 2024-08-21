package toy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.library.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
