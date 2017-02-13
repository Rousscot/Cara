

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.BiblioBeanRemote;

/**
 * Servlet implementation class ClientBiblio
 */
@WebServlet("/ServletAjouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BiblioBeanRemote myBean ;
	
	/**
     * Default constructor. 
     */
    public ServletAjouter() {
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
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String auteur =request.getParameter("auteur");
		String titre =request.getParameter("titre");
		myBean.ajouter(auteur, titre);
		out.println("<html><body>");
		out.println("<h1>Ajout d'un livre</h1>");
		out.println("Livre ajouté");
		out.println("</body></html>");
	}

}
