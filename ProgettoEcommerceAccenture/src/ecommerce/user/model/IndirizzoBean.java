package ecommerce.user.model;

public class IndirizzoBean {

	private int idIndirizzo;
	private String via;
	private int numero;
	private String citta;
	private int cap;
	private String utente;
	private String ultimoIndirizzo;
	
	public IndirizzoBean() {
		
	}

	public int getIdIndirizzo() {
		return idIndirizzo;
	}

	public void setIdIndirizzo(int idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getUltimoIndirizzo() {
		return ultimoIndirizzo;
	}

	public void setUltimoIndirizzo(String ultimoIndirizzo) {
		this.ultimoIndirizzo = ultimoIndirizzo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cap;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + idIndirizzo;
		result = prime * result + numero;
		result = prime * result + ((ultimoIndirizzo == null) ? 0 : ultimoIndirizzo.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
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
		IndirizzoBean other = (IndirizzoBean) obj;
		if (cap != other.cap)
			return false;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (idIndirizzo != other.idIndirizzo)
			return false;
		if (numero != other.numero)
			return false;
		if (ultimoIndirizzo == null) {
			if (other.ultimoIndirizzo != null)
				return false;
		} else if (!ultimoIndirizzo.equals(other.ultimoIndirizzo))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IndirizzoBean [idIndirizzo=" + idIndirizzo + ", via=" + via + ", numero=" + numero + ", citta=" + citta
				+ ", cap=" + cap + ", utente=" + utente + ", ultimoIndirizzo=" + ultimoIndirizzo + "]";
	}

	
	
	
}
