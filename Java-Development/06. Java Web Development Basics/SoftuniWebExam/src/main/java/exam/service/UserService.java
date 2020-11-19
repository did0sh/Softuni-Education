package exam.service;

import exam.domain.models.service.UserServiceModel;

public interface UserService {

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);
}
