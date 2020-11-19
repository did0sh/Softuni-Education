package metubev2.web.servlets;

import metubev2.domain.models.service.TubeServiceModel;
import metubev2.domain.models.view.TubeDetailsViewModel;
import metubev2.service.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/details/*")
public class TubeDetailServlet extends HttpServlet {

    private final TubeService tubeService;
    private final ModelMapper modelMapper;

    @Inject
    public TubeDetailServlet(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] urlParams = req.getRequestURI().split("/");
        String tubeId = urlParams[urlParams.length - 1];

        TubeServiceModel tubeServiceModel = this.tubeService.findTubeById(tubeId);
        tubeServiceModel.setViews(tubeServiceModel.getViews() + 1);

        if (tubeServiceModel.getViews() >= 1){
            this.tubeService.updateTubeViews(tubeServiceModel);
        } else {
            this.tubeService.uploadTube(tubeServiceModel);
        }

        TubeDetailsViewModel tubeDetailsViewModel =
                this.modelMapper.map(tubeServiceModel, TubeDetailsViewModel.class);

        req.setAttribute("model", null);
        req.setAttribute("model", tubeDetailsViewModel);

        req.getRequestDispatcher("/jsps/details.jsp")
                .forward(req, resp);
    }
}
