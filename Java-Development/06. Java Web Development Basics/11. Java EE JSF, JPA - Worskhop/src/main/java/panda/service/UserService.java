package panda.service;

import panda.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();

    UserServiceModel findByUsername(String username);
}
