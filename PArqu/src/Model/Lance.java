package Model;

public class Lance {
	private static int ID = 0;
	private Usuario comprador;
	private Produto produto;
	private double valor;
	
	public Lance(Usuario comprador, Produto produto, double valor) {
		this.ID = ++ID;
		this.comprador = comprador;
		this.produto = produto;
		this.valor = valor;
		System.out.println("Novo lance registrado" + this);
	}

	public int getID() {
		return this.ID;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double precoInicial) {
		this.valor = precoInicial;
	}	
	
	
	@Override
	public String toString() {
		return produto.getDescricao() + " lance " + ID + " " + comprador.getUserName() + " " + valor;
	}
}
