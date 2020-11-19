package productshop.service;


import productshop.domain.dtos.UserSeedDto;
import productshop.domain.dtos.UserSoldProductsDto;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);

    //Query 2
    List<UserSoldProductsDto> getAllUsersWithMoreThanOneSoldProduct();
}
