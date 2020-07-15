package ecommerce.prodotto.model;

public class AppartieneCategoriaBean {

	private int idProdotto;
	private int idCategoria;
	
	// costruttore default
	public AppartieneCategoriaBean() {
		
	}
	
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCategoria;
		result = prime * result + idProdotto;
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
		AppartieneCategoriaBean other = (AppartieneCategoriaBean) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (idProdotto != other.idProdotto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppartieneCategoriaBean [idProdotto=" + idProdotto + ", idCategoria=" + idCategoria + "]";
	}
	
	
}
