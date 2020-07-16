package ecommerce.ordine.model;

public class DettaglioBean {
	private int idDettaglio;
	private int idOrdine;
	private int idProdotto;
	private int quantitaAcquistata;
	private double prezzoUnitario;
	
	public DettaglioBean() {
		
	}

	public int getIdDettaglio() {
		return idDettaglio;
	}

	public void setIdDettaglio(int idDettaglio) {
		this.idDettaglio = idDettaglio;
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

	public int getQuantitaAcquistata() {
		return quantitaAcquistata;
	}

	public void setQuantitaAcquistata(int quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDettaglio;
		result = prime * result + idOrdine;
		result = prime * result + idProdotto;
		long temp;
		temp = Double.doubleToLongBits(prezzoUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantitaAcquistata;
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
		DettaglioBean other = (DettaglioBean) obj;
		if (idDettaglio != other.idDettaglio)
			return false;
		if (idOrdine != other.idOrdine)
			return false;
		if (idProdotto != other.idProdotto)
			return false;
		if (Double.doubleToLongBits(prezzoUnitario) != Double.doubleToLongBits(other.prezzoUnitario))
			return false;
		if (quantitaAcquistata != other.quantitaAcquistata)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioBean [idDettaglio=" + idDettaglio + ", idOrdine=" + idOrdine + ", idProdotto=" + idProdotto
				+ ", quantitaAcquistata=" + quantitaAcquistata + ", prezzoUnitario=" + prezzoUnitario + "]";
	}
	
	
	
}
