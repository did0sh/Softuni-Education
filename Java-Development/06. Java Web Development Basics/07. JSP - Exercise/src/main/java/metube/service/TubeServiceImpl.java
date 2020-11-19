package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;
import metube.repository.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveTube(TubeServiceModel tubeServiceModel) {
        Tube tube = this.modelMapper.map(tubeServiceModel, Tube.class);
        this.tubeRepository.save(tube);
    }

    @Override
    public TubeServiceModel findTubeByName(String name) {
        Tube tube = this.tubeRepository.findByName(name).orElse(null);

        return this.modelMapper.map(tube, TubeServiceModel.class);
    }

    @Override
    public List<TubeServiceModel> findAllTubes() {
        return this.tubeRepository.findAll()
                .stream().map(tube -> this.modelMapper.map(tube, TubeServiceModel.class))
                .collect(Collectors.toList());
    }
}
