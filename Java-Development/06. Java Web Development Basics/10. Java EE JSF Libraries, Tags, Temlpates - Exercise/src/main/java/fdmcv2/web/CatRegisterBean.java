package fdmcv2.web;

import fdmcv2.domain.models.binding.CatRegisterBindingModel;
import fdmcv2.domain.models.service.CatServiceModel;
import fdmcv2.service.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class CatRegisterBean implements Serializable {

    private CatRegisterBindingModel catRegisterBindingModel;
    private ModelMapper modelMapper;
    private CatService catService;

    public CatRegisterBean() {
        this.catRegisterBindingModel = new CatRegisterBindingModel();
    }

    @Inject
    public CatRegisterBean(ModelMapper modelMapper, CatService catService) {
        this();
        this.modelMapper = modelMapper;
        this.catService = catService;
    }

    public CatRegisterBindingModel getCatRegisterBindingModel() {
        return this.catRegisterBindingModel;
    }

    public void setCatRegisterBindingModel(CatRegisterBindingModel catRegisterBindingModel) {
        this.catRegisterBindingModel = catRegisterBindingModel;
    }

    public void register() throws IOException {
        this.catService
                .registerCat(this.modelMapper.map(this.catRegisterBindingModel, CatServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
