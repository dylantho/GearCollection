package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

@Entity
public class Collection {
	@Id
	@GeneratedValue
	private int id;
	private String collectionName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Weapon> listOfWeapons;
	
	
	public Collection() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCollectionName() {
		return collectionName;
	}


	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}


	public List<Weapon> getListOfWeapons() {
		return listOfWeapons;
	}


	public void setListOfWeapons(List<Weapon> listOfWeapons) {
		this.listOfWeapons = listOfWeapons;
	}


	@Override
	public String toString() {
		return "Collection [id=" + id + ", collectionName=" + collectionName + ", listOfWeapons=" + listOfWeapons + "]";
	}
	
	
	public Collection(int id, String collectionName, List<Weapon> listOfWeapons) {
		this.id = id;
		this.collectionName = collectionName;
		this.listOfWeapons = listOfWeapons;
	}
	
	public Collection(String collectionName, List<Weapon> listOfWeapons) {
		this.collectionName = collectionName;
		this.listOfWeapons = listOfWeapons;
	}
	
	public Collection(String collectionName) {
		this.collectionName = collectionName;
	}
	

}
