package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Collection;


/**
 * Servlet implementation class CollectionNavigationServlet
 */
@WebServlet("/collectionNavigationServlet")
public class CollectionNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionNavigationServlet() {
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
		CollectionHelper dao = new CollectionHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllCollectionsServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Collection collectionToDelete = dao.searchForCollectionById(tempId);
				dao.deleteCollection(collectionToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} 
			finally {
				getServletContext().getRequestDispatcher("/viewAllCollectionsServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Collection collectionToEdit = dao.searchForCollectionById(tempId);
				request.setAttribute("collectionToEdit", collectionToEdit);
				
				WeaponHelper daoForWeapons = new WeaponHelper();
				request.setAttribute("allItems", daoForWeapons.showAllWeapons());
				
				if(daoForWeapons.showAllWeapons().isEmpty()){
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-collection.jsp").forward(request, response);
			} 
			catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllCollectionsServlet").forward(request, response);
			}
		}
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-collection.jsp").forward(request, response);
		}
	}

}
