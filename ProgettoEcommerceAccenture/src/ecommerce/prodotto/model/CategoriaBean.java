package ecommerce.prodotto.model;

public class CategoriaBean {
	
	private int idCategoria;
	private String nome;
	private String urlImmagine;
	
	//costruttore Default
	public CategoriaBean() {
		
	}
	
	//getter e setter
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCategoria;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((urlImmagine == null) ? 0 : urlImmagine.hashCode());
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
		CategoriaBean other = (CategoriaBean) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (urlImmagine == null) {
			if (other.urlImmagine != null)
				return false;
		} else if (!urlImmagine.equals(other.urlImmagine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaBean [idCategoria=" + idCategoria + ", nome=" + nome + ", urlImmagine=" + urlImmagine + "]";
	}
	
	
}
