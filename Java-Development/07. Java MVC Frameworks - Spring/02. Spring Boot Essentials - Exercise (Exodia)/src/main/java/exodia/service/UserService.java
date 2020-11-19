package exodia.service;

import exodia.domain.entities.User;
import exodia.domain.models.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    User loginUser(UserServiceModel userServiceModel);
}
