package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordController {

	// método para mapear a rota (endereço) da página de recuperação
	// de senha do usuário /WEB-INF/views/password.jsp
	@RequestMapping(value = "/password")//ROTA (URL)
	public ModelAndView password() {

		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;
	}
}
