package exodia.web.controllers;

import exodia.domain.entities.User;
import exodia.domain.models.binding.UserLoginBindingModel;
import exodia.domain.models.binding.UserRegisterBindingModel;
import exodia.domain.models.service.UserServiceModel;
import exodia.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Validator;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, Validator validator) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        } else {
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(ModelAndView modelAndView,
                                        @ModelAttribute(name = "model") UserRegisterBindingModel model){

        UserServiceModel userServiceModel = this.modelMapper.map(model, UserServiceModel.class);
        if (!DigestUtils.sha256Hex(userServiceModel.getPassword()).equals(DigestUtils.sha256Hex(model.getConfirmPassword()))
            || this.validator.validate(model).size() != 0){
            modelAndView.setViewName("redirect:/register");
        } else {
            this.userService.registerUser(userServiceModel);
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        } else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(ModelAndView modelAndView,
                                     @ModelAttribute(name = "model") UserLoginBindingModel userLoginBindingModel,
                                     HttpSession session){

        UserServiceModel userServiceModel =
                this.modelMapper.map(userLoginBindingModel, UserServiceModel.class);

        User user = this.userService.loginUser(userServiceModel);
        if (user != null
                && DigestUtils.sha256Hex(userLoginBindingModel.getPassword())
                .equals(user.getPassword())){

            session.setAttribute("username", userServiceModel.getUsername());
            session.setAttribute("userID", userServiceModel.getId());

            modelAndView.setViewName("redirect:/home");
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            session.invalidate();
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }
}
