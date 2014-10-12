package br.com.fiap.tdst.am.advocacia.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControleProcessos
 */
@WebServlet({"/autentica","/logout"})
public class ControleProcessos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleProcessos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("index.jsp");
		
		/*
		 * Testando session  redirecionando para a propria pagina
		 * 
		String s = request.getParameter("nrProcesso");
		
		request.getSession().setAttribute("teste", s);
		
		response.sendRedirect("listarProcessos.jsp");
		
		System.out.println(s);
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		
	UsuarioDAO dao = new UsuarioDAO();
		
		HttpSession session = request.getSession();
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("password"));
	
				try{
					if(dao.verifica(usuario)==false){
						response.sendRedirect("index.jsp");
						System.out.println("false");
					}
					
					if(dao.verifica(usuario)){
						System.out.println("true");
						session.setAttribute("usuario", usuario);
						
						response.sendRedirect("principal.jsp");
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
			
	}

}
