package modelBean;

public class Autor {
	
	private int idAutor;
	private String nomeAutor;
	
	/**
	 * Construtor simples com todo valores  nulos
	 */
	public Autor() {
	
	}


	/**
	 * Construtor com nome Autor
	 */
	public Autor(String nomeAutor) {
		this.nomeAutor=nomeAutor;
	}
	
	
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	@Override
	public String toString() {
		return "Autor [nomeAutor=" + nomeAutor + "]";
	}
	
}
