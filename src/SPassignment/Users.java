package SPassignment;

public class Users {
	int id;
	String name;
	String email;
	String accountType;
	String address;
	
	public Users(int id, String name, String email, String accountType, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.accountType = accountType;
		this.address = address;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
