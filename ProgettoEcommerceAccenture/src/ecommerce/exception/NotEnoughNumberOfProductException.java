package ecommerce.exception;

public class NotEnoughNumberOfProductException extends Exception {
	public NotEnoughNumberOfProductException() {
		super("Non ci sono abbastanza prodotti per poter eseguire l'ordine");
	}
	public NotEnoughNumberOfProductException(String s) {
		super(s);
	}
}
