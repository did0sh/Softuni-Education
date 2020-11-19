package realestate.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realestate.domain.models.view.OfferViewModel;
import realestate.service.OfferService;
import realestate.util.HtmlReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(OfferService offerService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() throws IOException {
        return this.prepareHtml();
    }

    private String prepareHtml() throws IOException {
        List<OfferViewModel> offers =
                this.offerService.findAllOffers()
                        .stream()
                        .map(offerServiceModel -> this.modelMapper.map(offerServiceModel, OfferViewModel.class))
                        .collect(Collectors.toList());

        StringBuilder offersHtml = new StringBuilder();
        if (offers.size() == 0) {
            offersHtml.append("<div class=\"apartment\" style=\"border: red solid 1px\">")
                    .append("There aren't any offers!")
                    .append("</div>");

            return this.htmlReader.readHtmlFile("C:\\Users\\user\\IdeaProjects\\07. Java MVC Frameworks - Spring\\01.  Spring Boot Introduction - Exercise (Real Estate)\\src\\main\\resources\\static\\index.html")
                    .replace("{{offers}}", offersHtml.toString().trim());
        }

        for (OfferViewModel offer : offers) {
            offersHtml.append("<div class=\"apartment\">")
                    .append(String.format("<p>Rent: %s</p>", offer.getApartmentRent()))
                    .append(String.format("<p>Type: %s</p>", offer.getApartmentType()))
                    .append(String.format("<p>Commission: %s</p>", offer.getAgencyCommission()))
                    .append("</div>")
                    .append(System.lineSeparator());
        }

        return this.htmlReader.readHtmlFile("C:\\Users\\user\\IdeaProjects\\07. Java MVC Frameworks - Spring\\01.  Spring Boot Introduction - Exercise (Real Estate)\\src\\main\\resources\\static\\index.html")
                .replace("{{offers}}", offersHtml.toString().trim());
    }

}
