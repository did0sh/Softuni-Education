package fdmcv2.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BeansConfiguration {

    @Produces
    public EntityManager entityManager(){
        return Persistence
                .createEntityManagerFactory("fdmcv2")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
