package ecommerce.registration.validator;


import ecommerce.user.model.*;
public class RegistrationValidator {
	public static boolean validate(UserBean user, String newPassword) {
		PasswordValidator pv = new PasswordValidator();
		if(pv.validate(user.getPassword()) && checkConfirmedPassword(user.getPassword(),newPassword) && checkUsername(user.getUsername()) && checkNome(user.getNome()) && checkCognome(user.getCognome()))
			return true;
		else
			return false;
	}
	private static boolean checkUsername(String username) {
		if(!username.equals("") && username.length()>6) {
			return true;
		}else {
			return false;
		}
	}
	private static boolean checkNome(String nome) {
		if(nome!=null && !nome.equals(""))
			return true;
		else
			return false;
	}
	private static boolean checkCognome(String cognome) {
		if(cognome!=null && !cognome.equals(""))
			return true;
		else
			return false;
	}
	private static boolean checkConfirmedPassword(String pass, String confPass) {
		if(pass.equals(confPass))
			return true;
		else
			return false;
	}
}
