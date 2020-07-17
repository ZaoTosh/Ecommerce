package ecommerce.exception;

public class IdProductNotValidException extends Exception {
	public IdProductNotValidException() {
		super("Id Prodotto Non valido");
	}
	public IdProductNotValidException(String s) {
		super(s);
	}
}
