package panda.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import panda.domain.entities.User;
import panda.domain.models.service.UserServiceModel;
import panda.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        this.setUserRole(user);

        try {
            this.userRepository.save(user);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        User user = this.userRepository.findByUsername(userServiceModel.getUsername());
        if (user == null || !DigestUtils.sha256Hex(userServiceModel.getPassword()).equals(user.getPassword())){
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return  this.userRepository.findAll()
                .stream()
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.modelMapper
                .map(this.userRepository.findByUsername(username), UserServiceModel.class);
    }

    private void setUserRole(User user){
        user.setRole(this.userRepository.size() == 0 ? "Admin" : "User");
    }
}
