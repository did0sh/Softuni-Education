package exam.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class UserLogoutBean implements Serializable {

    public void logout() throws IOException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        session.invalidate();

        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("/faces/view/index.xhtml");
    }
}
