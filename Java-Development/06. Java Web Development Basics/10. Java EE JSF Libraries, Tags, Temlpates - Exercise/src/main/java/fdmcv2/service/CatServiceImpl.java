package fdmcv2.service;

import fdmcv2.domain.entities.Cat;
import fdmcv2.domain.models.service.CatServiceModel;
import fdmcv2.repository.CatRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;
    private final ModelMapper modelMapper;

    @Inject
    public CatServiceImpl(CatRepository catRepository, ModelMapper modelMapper) {
        this.catRepository = catRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean registerCat(CatServiceModel catServiceModel) {
        try {
            this.catRepository.save(this.modelMapper.map(catServiceModel, Cat.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<CatServiceModel> findAll() {
        return this.catRepository.findAll()
                .stream()
                .map(cat -> this.modelMapper.map(cat, CatServiceModel.class))
                .collect(Collectors.toList());
    }
}
