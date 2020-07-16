package ecommerce.ordine.model;

import java.time.LocalDate;

public class OrdineBean {
	private int idOrdine;
	private LocalDate dataOrdine;
	private double prezzoTotale;
	private String utente;
	private int indirizzo;
	
	public OrdineBean() {
		
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public LocalDate getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(LocalDate dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public int getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(int indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOrdine == null) ? 0 : dataOrdine.hashCode());
		result = prime * result + idOrdine;
		result = prime * result + indirizzo;
		long temp;
		temp = Double.doubleToLongBits(prezzoTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		OrdineBean other = (OrdineBean) obj;
		if (dataOrdine == null) {
			if (other.dataOrdine != null)
				return false;
		} else if (!dataOrdine.equals(other.dataOrdine))
			return false;
		if (idOrdine != other.idOrdine)
			return false;
		if (indirizzo != other.indirizzo)
			return false;
		if (Double.doubleToLongBits(prezzoTotale) != Double.doubleToLongBits(other.prezzoTotale))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineBean [idOrdine=" + idOrdine + ", dataOrdine=" + dataOrdine + ", prezzoTotale=" + prezzoTotale
				+ ", utente=" + utente + ", indirizzo=" + indirizzo + "]";
	}
	
	
}
