package Model;

public class Comprador {
	private static int ID = 0;
	private String userName;
	
	public Comprador(String userName) {
		this.userName = userName;
		this.ID = ++ID;		
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