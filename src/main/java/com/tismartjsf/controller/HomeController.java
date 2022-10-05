package com.tismartjsf.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="homeController")
@RequestScoped
public class HomeController {

	public void regresarHome() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/hospitales_jsf_jpa");
	}
	
}
