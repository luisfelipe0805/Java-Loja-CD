package modelBean;

public class CategoriaCD {
	private int idCategoria;
	private float menorPreco;
	private float maiorPreco;
	
	/**
	 * Construr simples 
	 */
	public CategoriaCD() {
		
	}
	
	/**
	 * Construtor com o id da categoria 
	 * @param id
	 */
	public CategoriaCD(int id) {
		this.idCategoria=id;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public float getMenorPreco() {
		return menorPreco;
	}
	public void setMenorPreco(float menorPreco) {
		this.menorPreco = menorPreco;
	}
	public float getMaiorPreco() {
		return maiorPreco;
	}
	public void setMaiorPreco(float maiorPreco) {
		this.maiorPreco = maiorPreco;
	}

	@Override
	public String toString() {
		return "CategoriaCD [idCategoria=" + idCategoria + ", menorPreco=" + menorPreco + ", maiorPreco=" + maiorPreco
				+ "]";
	}
	
	
}
