package ecommerce.user.dao;

import java.util.ArrayList;

import ecommerce.user.model.IndirizzoBean;

public interface IDaoIndirizzo {

	public boolean addIndirizzo (IndirizzoBean indirizzo);
	public boolean deleteIndirizzo (int idIndirizzo);
	public boolean updateIndirizzo (IndirizzoBean indirizzo);
	public IndirizzoBean getIndirizzoById (int idIndirizzo);
	public ArrayList<IndirizzoBean> getAllIndirizzi();
	
}
