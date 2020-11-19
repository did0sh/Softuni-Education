package exam.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BeanConfiguration {

    @Produces
    public EntityManager entityManager(){
        return Persistence
                .createEntityManagerFactory("sbojPU")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

