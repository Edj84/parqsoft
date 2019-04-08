package Model;

public class Transacao {
	private static int ID = 0;
	private Produto produto;
	private double preco;
	private Usuario devedor;
	private Usuario credor;
	private double taxa;
	
	public Transacao(Produto produto, double preco, Usuario devedor, Usuario credor, double taxa) {
		this.ID = ++ID;
		this.produto = produto;
		this.preco = preco;
		this.devedor = devedor;
		this.credor = credor;
		this.taxa = taxa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public Usuario getDevedor() {
		return devedor;
	}

	public void setDevedor(Usuario devedor) {
		this.devedor = devedor;
	}

	public Usuario getCredor() {
		return credor;
	}

	public void setCredor(Usuario credor) {
		this.credor = credor;
	}

	public static int getID() {
		return ID;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
}