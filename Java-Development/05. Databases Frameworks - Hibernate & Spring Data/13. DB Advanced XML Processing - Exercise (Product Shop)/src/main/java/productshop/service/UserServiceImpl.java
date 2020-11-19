package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.seed.UserSeedDto;
import productshop.domain.dtos.seed.xml.UsersUserDto;
import productshop.domain.dtos.view.ProductNamePriceFirstNameLastNameDto;
import productshop.domain.dtos.view.SoldProductsDto;
import productshop.domain.dtos.view.UserFirstNameLastNameDto;
import productshop.domain.dtos.view.xml.UserSoldProductsDto;
import productshop.domain.entities.User;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public void seedUsers(UsersUserDto userSeedDto) {
        for (UserSeedDto userDto : userSeedDto.getUserSeedDtos()) {
            if (!this.validatorUtil.isValid(userDto)){
                this.validatorUtil.violations(userDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            User entity = this.modelMapper.map(userDto, User.class);

            this.userRepository.saveAndFlush(entity);
        }
    }

    //Query 2
    @Override
    public UserSoldProductsDto getAllUsersWithMoreThanOneSoldProduct() {
        List<User> users = this.userRepository.getAllBySellContainsProductAndBuyer();

        List<ProductNamePriceFirstNameLastNameDto>
        productNamePriceFirstNameLastNameDtos = new ArrayList<>();

        List<SoldProductsDto> soldProductsDtos = new ArrayList<>();

        List<UserFirstNameLastNameDto> userFirstNameLastNameDtos = new ArrayList<>();
        Random random = new Random();

        for (User user : users) {
            ProductNamePriceFirstNameLastNameDto productNamePriceFirstNameLastNameDto
                    = new ProductNamePriceFirstNameLastNameDto();

            productNamePriceFirstNameLastNameDto.setName(user.getSell().get(random.nextInt(user.getSell().size())).getName());
            productNamePriceFirstNameLastNameDto.setBuyerFirstName(user.getFirstName());
            productNamePriceFirstNameLastNameDto.setBuyerLastName(user.getLastName());
            productNamePriceFirstNameLastNameDto.setPrice(user.getSell().get(random.nextInt(user.getSell().size())).getPrice());

            productNamePriceFirstNameLastNameDtos.add(productNamePriceFirstNameLastNameDto);

            SoldProductsDto soldProducts = new SoldProductsDto();
            soldProducts.setProductNamePriceFirstNameLastNameDtos(productNamePriceFirstNameLastNameDtos);

            soldProductsDtos.add(soldProducts);

            UserFirstNameLastNameDto userFirstNameLastNameDto = new UserFirstNameLastNameDto();
            userFirstNameLastNameDto.setFirstName(user.getFirstName());
            userFirstNameLastNameDto.setLastName(user.getLastName());
            userFirstNameLastNameDto.setSoldProductsDtos(soldProductsDtos);

            userFirstNameLastNameDtos.add(userFirstNameLastNameDto);
        }

        UserSoldProductsDto userSoldProductsDtos = new UserSoldProductsDto();
        userSoldProductsDtos.setUserFirstNameLastNameDtos(userFirstNameLastNameDtos);

        return userSoldProductsDtos;

    }
}
