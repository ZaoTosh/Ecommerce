package ecommerce.user.service;
import ecommerce.user.model.*;
import ecommerce.user.dao.*;

public class AddressService {
	private IndirizzoDaoImpl dao = new IndirizzoDaoImpl();
	
	public boolean addAddress(IndirizzoBean address) {
		if(dao.addIndirizzo(address))
			return true;
		else
			return false;
				
	}
	public boolean modifyAddress(IndirizzoBean address) {
		if(dao.updateIndirizzo(address))
			return true;
		else
			return false;
	}
	public boolean removeAddress(IndirizzoBean address) {
		if(dao.deleteIndirizzo(address.getIdIndirizzo()))
			return true;
		else
			return true;
	}
	public IndirizzoBean getUltimoIndirizzoByUser(String utente) {
		return dao.getUltimoIndirizzoByUser(utente);
	}
}
