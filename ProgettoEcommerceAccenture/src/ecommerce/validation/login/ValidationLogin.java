package ecommerce.validation.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ValidationLogin {
	final static Logger logger = Logger.getLogger(ValidationLogin.class); 
	private Pattern pattern;
    private Matcher matcher;
    
    private static final String PASSWORD_PATTERN = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,16}";
    //private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,16})";
    //private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[0-9]))";
    
    public ValidationLogin() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
 
    public boolean validatePassword(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
 
    }
    public boolean validateUsername(final String username) {
    	if(username.length()<6) {
    		return false;
    	}
    	return true;
    }
}
