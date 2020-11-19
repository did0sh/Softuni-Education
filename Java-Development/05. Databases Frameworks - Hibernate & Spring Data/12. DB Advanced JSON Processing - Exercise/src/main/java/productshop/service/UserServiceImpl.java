package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.SoldProductsDto;
import productshop.domain.dtos.UserSeedDto;
import productshop.domain.dtos.UserSoldProductsDto;
import productshop.domain.entities.User;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ValidatorUtil validatorUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)){
                this.validatorUtil.violations(userSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            User entity = this.modelMapper.map(userSeedDto, User.class);

            this.userRepository.saveAndFlush(entity);
        }
    }

    //Query 2
    @Override
    public List<UserSoldProductsDto> getAllUsersWithMoreThanOneSoldProduct() {
        List<User> users = this.userRepository.getAllBySellContainsProductAndBuyer();

        List<UserSoldProductsDto> userSoldProductsDtos = new ArrayList<>();

        for (User user : users) {
            UserSoldProductsDto userSoldProductsDto = this.modelMapper.map(user, UserSoldProductsDto.class);

            List<SoldProductsDto> soldProducts = user.getSell().stream().filter(sale -> sale.getBuyer() != null)
                    .map(sale -> this.modelMapper.map(sale, SoldProductsDto.class))
                    .collect(Collectors.toList());

            userSoldProductsDto.setSoldProducts(soldProducts);

            userSoldProductsDtos.add(userSoldProductsDto);
        }

        return userSoldProductsDtos;

    }
}
