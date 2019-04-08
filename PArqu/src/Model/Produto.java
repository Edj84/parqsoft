package Model;
public class Produto {
	private static int ID = 0;
	private String descricao;
	private double precoInicial;
	private Usuario vendedor;
	
	public Produto(String descricao, double precoInicial, Usuario vendedor) {
		this.ID = ++ID;
		this.descricao = descricao;
		this.precoInicial = precoInicial;
		this.vendedor = vendedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public int getID() {
		return this.ID;
	}

	public double getPrecoInicial() {
		return precoInicial;
	}
	
}
