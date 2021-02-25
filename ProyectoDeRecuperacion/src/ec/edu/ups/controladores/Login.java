package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ComentarioFacade;
import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Comentario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ClienteFacade ejbClienteFacade;
	@EJB
	private ComentarioFacade ejbComentarioFacade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		try {
	    	String correo= request.getParameter("user");
	    	String password = request.getParameter("password");
			Cliente cliente = ejbClienteFacade.inicioSesion(correo, password);
			List<Comentario> comentarios=ejbComentarioFacade.findAll();
			request.setAttribute("cliente", cliente);
			request.setAttribute("comentarios", comentarios);
			if (cliente != null) {
				url="/Comentarios.jsp";
			}
		}catch (Exception e) {
			System.out.println("qhygfdghasdhgfuyigwsadfuyiwqeyruiuyiewqr:eftrewrtewqt");
			url = "/loguin.xhtml";
		}
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
