package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cEmail = request.getParameter("email");
		String cSenha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(cEmail);
		usuario.setPassword(cSenha);
		
		UsuarioService cs = new UsuarioService();
		if(cs.validar(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou " + usuario.getEmail() + "-" +  usuario.getPassword());
		}else {
			System.out.println("Não Logou " + usuario);
			throw new ServletException("Usuário/Senha inválidos");
		}
		
		response.sendRedirect("index.jsp");

	}

}
