package toy.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.library.domain.User;
import toy.library.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public List<User> userList(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public void DeleteUser(Long userId){
        userRepository.deleteById(userId);
    }

}
