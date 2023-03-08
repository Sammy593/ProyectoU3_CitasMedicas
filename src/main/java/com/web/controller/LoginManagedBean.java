package com.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Usuario;

@ManagedBean(name = "LoginManagedBean")
@ViewScoped
public class LoginManagedBean {

	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	Usuario u = (Usuario) sessionMap.get("userLogged");

	public void verifySessionNoLogged() {

		

		HttpServletResponse response = (HttpServletResponse) this.externalContext.getResponse();

		String pathToIndex = "http://localhost:8080/jpa/faces/login.xhtml";

		String pageReq = this.getReqPath();

		if (this.u == null && pageReq != pathToIndex) {
			try {
				response.sendRedirect("/jpa/faces/login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void verifySessionInLoggIn() {

		

		HttpServletResponse response = (HttpServletResponse) this.externalContext.getResponse();

		String pathToIndex = "http://localhost:8080/jpa/faces/index.xhtml";

		String pageReq = this.getReqPath();

		if (this.u != null && pageReq.equals(pathToIndex)) {
			try {
				response.sendRedirect("/jpa/faces/user_index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String getReqPath() {
		HttpServletRequest request = (HttpServletRequest) this.externalContext.getRequest();

		StringBuffer url = request.getRequestURL();
		String queryString = request.getQueryString();

		if (queryString != null) {
			url.append("?").append(queryString);
		}
		String pageReq = url.toString();
		System.out.println("Page requerid by cliente: " + pageReq);
		return pageReq;
	}
	
}