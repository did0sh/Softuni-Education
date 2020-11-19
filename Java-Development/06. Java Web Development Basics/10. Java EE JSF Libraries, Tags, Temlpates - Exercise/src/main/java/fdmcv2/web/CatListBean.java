package fdmcv2.web;

import fdmcv2.domain.models.binding.CatListViewModel;
import fdmcv2.service.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class CatListBean implements Serializable {

    private CatService catService;
    private List<CatListViewModel> catListViewModels;
    private ModelMapper modelMapper;

    public CatListBean() {
    }

    @Inject
    public CatListBean(CatService catService, ModelMapper modelMapper) {
        this.catService = catService;
        this.modelMapper = modelMapper;
        this.catListViewModels =
                this.catService.findAll()
                .stream().map(catServiceModel -> this.modelMapper.map(catServiceModel, CatListViewModel.class))
                .collect(Collectors.toList());
    }

    public List<CatListViewModel> getCatListViewModels() {
        return this.catListViewModels;
    }
}
