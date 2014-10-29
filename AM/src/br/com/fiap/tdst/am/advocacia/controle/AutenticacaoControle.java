package br.com.fiap.tdst.am.advocacia.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.tdst.am.advocacia.beans.Usuario;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleUsuarioDAO;

/**
 * Servlet implementation class ControleProcessos
 */
@WebServlet({"/autentica","/logout"})
public class AutenticacaoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticacaoControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		OracleUsuarioDAO dao = new OracleUsuarioDAO();
		
		
		HttpSession session =request.getSession();
		
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("password"));
		
		
		if(!(usuario.getLogin().isEmpty()|| usuario.getSenha().isEmpty())){
			try {
				if(dao.verifica(usuario)==true){
				
					session.setAttribute("usuarioLogado", usuario);
					response.sendRedirect("principal.jsp");
				}else
					response.sendRedirect("index.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		
		
	}

}
