package residentevil.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import residentevil.domain.model.binding.VirusAddBindingModel;
import residentevil.domain.model.service.VirusServiceModel;
import residentevil.domain.model.view.CapitalViewModel;
import residentevil.service.CapitalService;
import residentevil.service.VirusService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viruses")
public class VirusController extends BaseController {

    private final CapitalService capitalService;
    private final ModelMapper modelMapper;
    private final VirusService virusService;

    @Autowired
    public VirusController(CapitalService capitalService, ModelMapper modelMapper, VirusService virusService) {
        this.capitalService = capitalService;
        this.modelMapper = modelMapper;
        this.virusService = virusService;
    }

    @GetMapping("/add")
    public ModelAndView add(
            @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel,
            ModelAndView modelAndView) {

        modelAndView.addObject("bindingModel", bindingModel);

        List<CapitalViewModel> capitals = this.capitalService.findAllCapitals()
                .stream()
                .map(c -> this.modelMapper.map(c, CapitalViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("capitals", capitals);
        return super.view("add-virus", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(
            @Valid
            @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel,
            BindingResult bindingResult,
            ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingModel", bindingModel);
            return super.view("add-virus", modelAndView);
        }

        VirusServiceModel model = this.modelMapper.map(bindingModel, VirusServiceModel.class);
        this.virusService.saveVirus(model);
        return super.redirect("/");
    }
}
