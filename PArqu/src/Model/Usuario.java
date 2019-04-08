package Model;

public class Usuario {
	private static int ID = 0;
	private String userName;
	private int tipo; // 0 = admin do sistema; 1 = vendedor; 2 = comprador
	
	public Usuario(String userName, int tipo) {
		this.userName = userName;
		this.ID = ++ID;
		this.tipo = tipo;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String novoUserName) {
		this.userName = novoUserName;
	}
	
}
