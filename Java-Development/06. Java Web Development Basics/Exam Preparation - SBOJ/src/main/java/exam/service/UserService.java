package exam.service;

import exam.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel login(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();
}
