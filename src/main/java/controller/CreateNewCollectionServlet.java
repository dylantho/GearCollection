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
 * Servlet implementation class CreateNewCollectionServlet
 */
@WebServlet("/createNewCollectionServlet")
public class CreateNewCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WeaponHelper wh = new WeaponHelper();
		String collectionName = request.getParameter("collectionName");
		System.out.println("Collection Name: " + collectionName);
		
		
		String[] selectedWeapons = request.getParameterValues("allItemsToAdd");
		List<Weapon> selectedWeaponsInList = new ArrayList<Weapon>();
		
		if (selectedWeapons != null && selectedWeapons.length > 0){
			for(int i = 0; i < selectedWeapons.length; i++) {
				System.out.println(selectedWeapons[i]);
				Weapon w = wh.searchForWeaponById(Integer.parseInt(selectedWeapons[i]));
				selectedWeaponsInList.add(w);
			}
		}

		Collection cn = new Collection(collectionName);
				
		cn.setListOfWeapons(selectedWeaponsInList);
		CollectionHelper ch = new CollectionHelper();
		ch.insertNewCollection(cn);
		System.out.println("Created collection.\n");
		System.out.println(cn.toString());
		getServletContext().getRequestDispatcher("/viewAllCollectionsServlet").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
