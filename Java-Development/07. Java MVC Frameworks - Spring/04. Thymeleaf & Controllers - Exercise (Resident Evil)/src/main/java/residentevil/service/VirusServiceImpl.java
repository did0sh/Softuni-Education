package residentevil.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import residentevil.domain.entities.Virus;
import residentevil.domain.model.service.VirusServiceModel;
import residentevil.repository.VirusRepository;

@Service
public class VirusServiceImpl implements VirusService {
    private final ModelMapper modelMapper;
    private final VirusRepository virusRepository;

    @Autowired
    public VirusServiceImpl(ModelMapper modelMapper, VirusRepository virusRepository) {
        this.modelMapper = modelMapper;
        this.virusRepository = virusRepository;
    }

    @Override
    public boolean saveVirus(VirusServiceModel virusServiceModel) {
        try {
            Virus virus = this.modelMapper.map(virusServiceModel, Virus.class);
            this.virusRepository.saveAndFlush(virus);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
