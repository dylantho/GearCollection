package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Collection;
import model.Weapon;

/**
 * Servlet implementation class editCollectionServlet
 */
@WebServlet("/editCollectionServlet")
public class editCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCollectionServlet() {
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
		// TODO Auto-generated method stub
		CollectionHelper dao = new CollectionHelper();
				
		WeaponHelper wh = new WeaponHelper();

		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Collection collectionToUpdate = dao.searchForCollectionById(tempId);
		String newCollectionName = request.getParameter("collectionName");
				
		try {
		//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Weapon> selectedWeaponsInList = new ArrayList<Weapon>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Weapon w = wh.searchForWeaponById(Integer.parseInt(selectedItems[i]));
				selectedWeaponsInList.add(w);
			}
			collectionToUpdate.setListOfWeapons(selectedWeaponsInList);
		}
		catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Weapon> selectedWeaponsInList = new ArrayList<Weapon>();
			collectionToUpdate.setListOfWeapons(selectedWeaponsInList);
		}
				
		collectionToUpdate.setCollectionName(newCollectionName);

		dao.updateCollection(collectionToUpdate);
		getServletContext().getRequestDispatcher("/viewAllCollectionsServlet").forward(request, response);
	}

}
