package realestate.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.domain.entities.Offer;
import realestate.domain.models.binding.OfferFindBindingModel;
import realestate.domain.models.service.OfferServiceModel;
import realestate.repository.OfferRepository;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
        if (this.validator.validate(offerServiceModel).size() != 0){
            throw new IllegalArgumentException("Something went wrong!");
        }

        Offer offer = this.modelMapper.map(offerServiceModel, Offer.class);
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public List<OfferServiceModel> findAllOffers() {
        return this.offerRepository.findAll()
                .stream()
                .map(offer -> this.modelMapper.map(offer, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void findOffer(OfferFindBindingModel offerFindBindingModel) {
        if (this.validator.validate(offerFindBindingModel).size() != 0){
            throw new IllegalArgumentException("Something went wrong!");
        }

        Offer offer = this.offerRepository.findAll()
                .stream()
                .filter(offer1 -> offer1.getApartmentType().toLowerCase().equals(offerFindBindingModel.getFamilyApartmentType().toLowerCase())
                         && offerFindBindingModel.getFamilyBudget()
                        .compareTo(offer1.getApartmentRent().add(offer1.getAgencyCommission().divide(new BigDecimal("100"))
                        .multiply(offer1.getApartmentRent()))) >= 0)
                .map(offer1 -> this.modelMapper.map(offer1, Offer.class))
                .findFirst()
                .orElse(null);

        if (offer == null){
            throw new IllegalArgumentException("Something went wrong!");
        }

        this.offerRepository.delete(offer);
    }
}
