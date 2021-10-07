import java.util.ArrayList;
import java.util.List;

import controller.CollectionHelper;
import model.Collection;
import model.Weapon;


/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class CollectionTester {

	public static void main(String[] args) {
		
		CollectionHelper ch = new CollectionHelper();
		
		Weapon drang = new Weapon("Drang", "Sidearm");
		Weapon fatebringer = new Weapon("Fatebringer", "Hand Cannon");
		
		List<Weapon> pvpWeapons = new ArrayList<Weapon>();
		
		pvpWeapons.add(drang);
		pvpWeapons.add(fatebringer);
		
		Collection dylansCollection = new Collection("Dylan's PvP Weapons");
		
		dylansCollection.setListOfWeapons(pvpWeapons);
		ch.insertNewCollection(dylansCollection);
		
		
		List<Collection> allLists = ch.getLists();
		
		for(Collection a: allLists) {
			System.out.println(a.toString());
		}

	}
	
	
	public CollectionTester() {
		// TODO Auto-generated constructor stub
	}

}
