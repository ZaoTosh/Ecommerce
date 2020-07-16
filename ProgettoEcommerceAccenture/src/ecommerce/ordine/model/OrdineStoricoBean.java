package ecommerce.ordine.model;

public class OrdineStoricoBean {
	
	private int idOrdine;
	private int idProdotto;
	private String username;
	private int quantitaAcquistata;
	private double prezzoTotale;
	
	public OrdineStoricoBean() {
		
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getQuantitaAcquistata() {
		return quantitaAcquistata;
	}

	public void setQuantitaAcquistata(int quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOrdine;
		result = prime * result + idProdotto;
		long temp;
		temp = Double.doubleToLongBits(prezzoTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantitaAcquistata;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdineStoricoBean other = (OrdineStoricoBean) obj;
		if (idOrdine != other.idOrdine)
			return false;
		if (idProdotto != other.idProdotto)
			return false;
		if (Double.doubleToLongBits(prezzoTotale) != Double.doubleToLongBits(other.prezzoTotale))
			return false;
		if (quantitaAcquistata != other.quantitaAcquistata)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineStoricoBean [idOrdine=" + idOrdine + ", idProdotto=" + idProdotto + ", username=" + username
				+ ", quantitaAcquistata=" + quantitaAcquistata + ", prezzoTotale=" + prezzoTotale + "]";
	}
	
	
}
