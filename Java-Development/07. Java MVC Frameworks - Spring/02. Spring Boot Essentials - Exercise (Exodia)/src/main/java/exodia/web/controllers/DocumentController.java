package exodia.web.controllers;

import exodia.domain.entities.Document;
import exodia.domain.models.binding.DocumentBindingModel;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.domain.models.view.DocumentDetailsViewModel;
import exodia.domain.models.view.DocumentHomeViewModel;
import exodia.domain.models.view.DocumentPrintViewModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Validator;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper, Validator validator) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("/schedule");
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(ModelAndView modelAndView,
                                        @ModelAttribute(name = "document") DocumentBindingModel model){

        DocumentServiceModel documentServiceModel =
                this.modelMapper.map(model, DocumentServiceModel.class);

        if (this.validator.validate(model).size() == 0){
            Document document = this.documentService.saveDocument(documentServiceModel);
            modelAndView.setViewName("redirect:/details/" + document.getId());
        } else {
            modelAndView.setViewName("redirect:/schedule");
        }

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable(name = "id") String id, ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            DocumentServiceModel model = this.documentService.findDocumentById(id);

            DocumentDetailsViewModel detailModel = this.modelMapper.map(model, DocumentDetailsViewModel.class);

            modelAndView.setViewName("details");
            modelAndView.addObject("detailModel", detailModel);
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/print/{id}")
    public ModelAndView print(@PathVariable(name = "id") String id, ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            DocumentServiceModel model = this.documentService.findDocumentById(id);

            DocumentPrintViewModel printModel = this.modelMapper.map(model, DocumentPrintViewModel.class);

            modelAndView.setViewName("print");
            modelAndView.addObject("printModel", printModel);
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @PostMapping("/print/{id}")
    public ModelAndView printConfirm(@PathVariable(name = "id") String id, ModelAndView modelAndView){
        if (this.documentService.printDocument(id)){
            modelAndView.setViewName("redirect:/home");
        } else {
            modelAndView.setViewName("redirect:/print/{id}");
        }

        return modelAndView;
    }
}
