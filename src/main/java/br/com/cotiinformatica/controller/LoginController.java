package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

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

	// Método para capturar o SUBMIT POST formulário:
	@RequestMapping(value = "/login-user", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("login");

		try {

			// resgatar o email e a senha enviados pelo formulário
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			// consultando o usuário no banco de dados atraves do email e da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);

			// verificar se o usuário foi encontrado
			if (usuario != null) {

				//autenticação do usuário
				//gravando o usuário em uma sessão
				request.getSession().setAttribute("usuario_auth", usuario);
				
				//redirecionar para a página da área restrita
				modelAndView.setViewName("redirect:admin/home");

			} 
			else {
				modelAndView.addObject("mensagem_erro", "Acesso negado. Usuário inválido.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao autenticar o usuário: " + e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar os dados do usuário gravado em sessão
		request.getSession().removeAttribute("usuario_auth");
		
		//redirecionar o usuário de volta para a página inicial do sistema (login)
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

	
}
