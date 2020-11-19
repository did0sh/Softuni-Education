package cardealer.config;

import cardealer.util.ValidatorUtil;
import cardealer.util.ValidatorUtilImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ValidatorUtil validatorUtil(){
        return new ValidatorUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
