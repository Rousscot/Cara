

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.BiblioBeanRemote;
import biblio.Book;

/**
 * Servlet implementation class ClientBiblio
 */
@WebServlet("/ServletChercher")
public class ServletChercher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BiblioBeanRemote myBean ;
	
	/**
     * Default constructor. 
     */
    public ServletChercher() {
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
		String titre =request.getParameter("titre");
		Book b = myBean.getLivre(titre);
		out.println("<html><body>");
		out.println("<h1>Résultat de la recherche</h1>");
		if(b!=null)
		    out.println(b.getTitle() + " " + b.getAuthor());
		else
			out.println("non trouvé");
		out.println("</body></html>");
	}

}
