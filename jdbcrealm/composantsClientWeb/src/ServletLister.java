

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/ServletLister")
public class ServletLister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BiblioBeanRemote myBean ;
	
	/**
     * Default constructor. 
     */
    public ServletLister() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request,response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		List<String> l = myBean.liste();
		out.println("<html><body>");
		out.println("<h1>Liste des titres</h1>");
		for(String t:l) 
		out.println(t + "<p>");
		out.println("</body></html>");
	}

}
