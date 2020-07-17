package ecommerce.user.service;
import ecommerce.user.model.*;
import ecommerce.user.dao.*;

public class AddressService {

	private IndirizzoDaoImpl dao = new IndirizzoDaoImpl();
	
	public boolean addAddress(IndirizzoBean address) {
		String usernameInput = address.getUtente();
		IndirizzoBean ultimoIndirizzoUtilizzato =  getUltimoIndirizzoByUser(usernameInput);
		if(ultimoIndirizzoUtilizzato == null) {
			return dao.addIndirizzo(address);
		}
		else {
			ultimoIndirizzoUtilizzato.setUltimoIndirizzo("N");
			dao.updateIndirizzo(ultimoIndirizzoUtilizzato);
			return dao.addIndirizzo(address);
		}			
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
