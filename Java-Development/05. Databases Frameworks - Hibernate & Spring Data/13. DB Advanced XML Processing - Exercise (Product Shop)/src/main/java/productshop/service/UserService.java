package productshop.service;


import productshop.domain.dtos.seed.xml.UsersUserDto;
import productshop.domain.dtos.view.xml.UserSoldProductsDto;

import java.util.List;

public interface UserService {

    void seedUsers(UsersUserDto userSeedDto);

    //Query 2
    UserSoldProductsDto getAllUsersWithMoreThanOneSoldProduct();
}
