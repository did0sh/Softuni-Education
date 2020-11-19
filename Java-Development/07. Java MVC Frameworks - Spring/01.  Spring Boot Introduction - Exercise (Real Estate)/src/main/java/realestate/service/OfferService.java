package realestate.service;

import org.springframework.stereotype.Service;
import realestate.domain.models.binding.OfferFindBindingModel;
import realestate.domain.models.service.OfferServiceModel;

import java.util.List;

@Service
public interface OfferService {

    void registerOffer(OfferServiceModel offerServiceModel);

    List<OfferServiceModel> findAllOffers();

    void findOffer(OfferFindBindingModel offerFindBindingModel);
}
