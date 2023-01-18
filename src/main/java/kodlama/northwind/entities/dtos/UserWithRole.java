package kodlama.northwind.entities.dtos;

public class UserWithRole {
	
	private String userName;
	private String roleName;
	
	
	
	
	public UserWithRole()
	{
		
	}
	
	public UserWithRole(String userName, String roleName) {
		super();
		this.userName = userName;
		this.roleName = roleName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
