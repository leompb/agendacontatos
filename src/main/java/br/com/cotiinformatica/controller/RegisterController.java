package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	// Método para mapear a página que será exibida por este controlador
	@RequestMapping(value = "/register")//ROTA (URL)
	public ModelAndView register() {

		// Definir o nome da página que o controlador deverá exibir na rota
		// esta página deve estar dentro de /WEB-INF/views e ter extensão .jsp

		// WEB-INF/views/register.jsp
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
}
