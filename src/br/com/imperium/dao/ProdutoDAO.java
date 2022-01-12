package br.com.imperium.dao;

public class ProdutoDAO {

	
	private int id;
	private String codigoBarras;
	private String codigoPersonalizado;
	private String descricao;
	private String tipo;
	private String categoria;
	private String fornecedor;
	private int estoqueMinimo;
	private double valorCusto;
	private double margemLucro;
	private double valorVenda;
	private String status;
	private String dataCadasto;
	private int quantidadeEstoque;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getCodigoPersonalizado() {
		return codigoPersonalizado;
	}
	public void setCodigoPersonalizado(String codigoPersonalizado) {
		this.codigoPersonalizado = codigoPersonalizado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
	public double getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDataCadasto() {
		return dataCadasto;
	}
	public void setDataCadasto(String dataCadasto) {
		this.dataCadasto = dataCadasto;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}	

}
