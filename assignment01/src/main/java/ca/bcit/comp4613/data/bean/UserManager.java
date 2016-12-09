package ca.bcit.comp4613.data.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import ca.bcit.comp4613.database.util.DBUtil;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserManager {

	public String logout() throws IOException {
		DBUtil db = DBUtil.getInstance();
		db.shutdown();
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath());
	    return null;
	}
}
