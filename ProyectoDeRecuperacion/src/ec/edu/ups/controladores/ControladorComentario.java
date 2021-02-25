package ec.edu.ups.controladores;

import java.io.IOException;
import java.nio.charset.CodingErrorAction;
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
import ec.edu.ups.entidades.Tienda;

/**
 * Servlet implementation class Comentario
 */
@WebServlet("/ControladorComentario")
public class ControladorComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	private ComentarioFacade ejbComentarioFacade;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
    public ControladorComentario() {
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
			int codigoCli=Integer.parseInt(request.getParameter("idCli"));
			Tienda tienda = new Tienda(1,"Tienda 1","Cuenca");
	    	Cliente cliente=ejbClienteFacade.find(codigoCli);
			String comentario = request.getParameter("comentario");
	    	Comentario coment=new Comentario(0,comentario, cliente, tienda);
			ejbComentarioFacade.create(coment);
			List<Comentario> comentarios=ejbComentarioFacade.findAll();
			request.setAttribute("cliente", cliente);
			request.setAttribute("comentarios", comentarios);
			if (cliente != null) {
				url="/Comentarios.jsp";
			}
		}catch (Exception e) {
			url = "/Comentarios.xhtml";
		}
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
