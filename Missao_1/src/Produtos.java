//classe de produtos com funcoes get e set para cada elemento.
class Produtos {
	public String nomeProd, descricao;
	public double valor, lucro;
	public int estoque;
	
	public String getNomeProd() {
		return nomeProd;
	}
	public String getDesc() {
		return descricao;
	}
	public double getValor() {
		return valor;
	}
	public double getLucro() {
		return lucro;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public void setDesc(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
}
