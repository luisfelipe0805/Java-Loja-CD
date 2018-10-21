package modelBean;

import java.util.Date;

public class CD {
	
	
	private int idcd;
	private int cdIndicado;
	private int idGravadora;
	private String nomeCD;
	private float precoVenda;
	private Date dtLancamento;
	
	/**
	 * Construtor simples com todo valores  nulos
	 */
	public CD() {
		
	}
	
	
	/**
	 * Construtor com nome CD e id da Gravadora
	 */
	public CD(String nomeCD,int idGravadora) {
		this.nomeCD=nomeCD;
		this.idGravadora=idGravadora;
	}
	
	/**
	 * Construtor com nome CD, id da Gravadora e preco do cd
	 */
	public CD(String nomeCD,int idGravadora,float precoVenda) {
		this.nomeCD=nomeCD;
		this.idGravadora=idGravadora;
		this.precoVenda=precoVenda;
	}
	
	
	public int getIdcd() {
		return idcd;
	}
	public void setIdcd(int idcd) {
		this.idcd = idcd;
	}
	public int getCdIndicado() {
		return cdIndicado;
	}
	public void setCdIndicado(int cdIndicado) {
		this.cdIndicado = cdIndicado;
	}
	public int getIdGravadora() {
		return idGravadora;
	}
	public void setIdGravadora(int idGravadora) {
		this.idGravadora = idGravadora;
	}
	public String getNomeCD() {
		return nomeCD;
	}
	public void setNomeCD(String nomeCD) {
		this.nomeCD = nomeCD;
	}
	public float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public Date getDtLancamento() {
		return dtLancamento;
	}
	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}


	@Override
	public String toString() {
		return "CD [nomeCD=" + nomeCD + ", precoVenda=" + precoVenda + ", dtLancamento=" + dtLancamento + "]";
	}
	
	
	
}
