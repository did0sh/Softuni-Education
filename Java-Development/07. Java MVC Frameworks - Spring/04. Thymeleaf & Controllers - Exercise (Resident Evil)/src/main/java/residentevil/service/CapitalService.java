package residentevil.service;

import residentevil.domain.model.service.CapitalServiceModel;

import java.util.List;

public interface CapitalService {

    List<CapitalServiceModel> findAllCapitals();
}
