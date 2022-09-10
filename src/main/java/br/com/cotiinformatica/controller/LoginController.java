package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// Método para mapear o endereço através do qual a página de login será acessada
	// neste caso a página de login será a ROTA (URL) inicial do projeto

	@RequestMapping(value = "/") // ROTA (endereço) -> raiz do projeto
	public ModelAndView login() {

		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
