package fdmcv2.service;

import fdmcv2.domain.models.service.CatServiceModel;

import java.util.List;

public interface CatService {

    boolean registerCat(CatServiceModel catServiceModel);

    List<CatServiceModel> findAll();
}
