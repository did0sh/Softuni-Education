package gamestore.services.api;

import gamestore.dto.GameOwnedView;
import gamestore.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void registerUser(User user, String confirmPassword);

    User findByEmail(String email);

    List<GameOwnedView> findOwnedGames(String email);

    List<User> getAllUsers();

    void update(User user);
}
