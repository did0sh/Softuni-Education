package metubev2.web.filters;

import metubev2.domain.models.binding.TubeUploadBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tube/upload")
public class TubeUploadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().toLowerCase().equals("post")) {
            TubeUploadBindingModel tubeUploadBindingModel = new TubeUploadBindingModel();
            tubeUploadBindingModel.setTitle(request.getParameter("title"));
            tubeUploadBindingModel.setAuthor(request.getParameter("author"));
            tubeUploadBindingModel.setYoutubeLink(request.getParameter("youtube-link"));
            tubeUploadBindingModel.setDescription(request.getParameter("description"));
            tubeUploadBindingModel.setUploader((String) request.getSession().getAttribute("username"));

            request.setAttribute("tubeUploadModel", tubeUploadBindingModel);
        }

        filterChain.doFilter(request, response);
    }
}
