package ecommerce.registration.validator;

public class AddressValidator {
	public static boolean validate(String via, String numero, String citta, String cap ) {
		try {
			int number = Integer.parseInt(numero);
			int caps = Integer.parseInt(cap);
		}catch(NumberFormatException nfe) {
			return false;
		}
		if((via != null && !via.equals(""))&& (citta != null && !citta.equals(""))) {
			return true;
		}
		return false;
	}
}
