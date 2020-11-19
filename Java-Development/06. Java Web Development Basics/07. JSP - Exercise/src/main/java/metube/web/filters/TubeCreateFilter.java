package metube.web.filters;

import metube.domain.models.binding.TubeCreateBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tubes/create")
public class TubeCreateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().toLowerCase().equals("post")){
            TubeCreateBindingModel tubeCreateBindingModel = new TubeCreateBindingModel();
            tubeCreateBindingModel.setName(request.getParameter("title"));
            tubeCreateBindingModel.setDescription(request.getParameter("description"));
            tubeCreateBindingModel.setYoutubeLink(request.getParameter("youtubeLink"));
            tubeCreateBindingModel.setUploader(request.getParameter("uploader"));

            request.setAttribute("tubeCreateBindingModel", tubeCreateBindingModel);
        }

        filterChain.doFilter(request, response);

    }
}
