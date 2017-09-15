package com.theironyard.invoicify.models;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserAdditionAspect {

	@ModelAttribute
	public void addUserInformation(Model model, Authentication auth, HttpServletRequest request) {
		if (auth == null) {
			model.addAttribute("notUser", true);
		} else {
			boolean isAdmin = request.isUserInRole("ADMIN");
			model.addAttribute("user", auth.getPrincipal());
			model.addAttribute("isAdmin", isAdmin);
		}
	}

}
