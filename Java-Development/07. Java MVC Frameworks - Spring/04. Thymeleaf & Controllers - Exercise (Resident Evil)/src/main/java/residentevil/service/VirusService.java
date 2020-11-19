package residentevil.service;

import org.springframework.stereotype.Service;
import residentevil.domain.model.service.VirusServiceModel;

public interface VirusService {

    boolean saveVirus(VirusServiceModel virusServiceModel);
}
