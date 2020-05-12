package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNome = request.getParameter("nome");
		String cEmail = request.getParameter("email");
		String cSenha = request.getParameter("senha");	
		String cFone = request.getParameter("fone");
		
        //instanciar o javabean
        Usuario usuario = new Usuario();
        usuario.setNome(cNome);
        usuario.setEmail(cEmail);
        usuario.setPassword(cSenha);
        usuario.setFone(cFone);
                
        //instanciar o service
        UsuarioService cs = new UsuarioService();
        
        cs.criar(usuario);
        
        request.getRequestDispatcher("Login.jsp").
		forward(request, response);
        
	}

}
