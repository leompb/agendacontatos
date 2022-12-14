package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class ConsultarContatoController {

	@RequestMapping(value = "/admin/consultar-contato")
	public ModelAndView consultarContato(HttpServletRequest request) {

		// WEB-INF/views/admin/consultar-contato
		ModelAndView modelAndView = new ModelAndView("admin/consultar-contato");

		try {

			// ler o usuário da sessão (usuário autenticado)
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			// consultar todos os contatos deste usuário
			ContatoRepository contatoRepository = new ContatoRepository();
			List<Contato> lista = contatoRepository.findByUsuario(usuario.getIdUsuario());

			// enviando a lista para a página
			modelAndView.addObject("lista_contatos", lista);
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao consultar contatos: " + e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/admin/excluir-contato")
	public ModelAndView excluirContato(HttpServletRequest request) {

		// WEB-INF/views/admin/consultar-contato
		ModelAndView modelAndView = new ModelAndView("admin/consultar-contato");

		try {
			
			//capturar o usuário autenticado no sistema (sessão)
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			//capturar o id do contato enviado pela URL
			Integer idContato = Integer.parseInt(request.getParameter("idContato"));
			
			//consultar o contato no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			Contato contato = contatoRepository.findById(idContato, usuario.getIdUsuario());
			
			//verificar se o contato foi encontrado
			if(contato != null) {
				
				//excluindo o contato
				contatoRepository.delete(contato);
				modelAndView.addObject("mensagem_sucesso", "Contato " + contato.getNome() + " excluído com sucesso.");
			}
			
			List<Contato> lista = contatoRepository.findByUsuario(usuario.getIdUsuario());

			// enviando a lista para a página
			modelAndView.addObject("lista_contatos", lista);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao excluir contatos: " + e.getMessage());
		}
		
		return modelAndView;
	}

}











