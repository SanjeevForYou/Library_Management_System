package lms.util;

public class Auth {
	private String userName;
	private String password;
	private Role role;
	
	public void setUserName(String username)
	{
		this.userName = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setRole(Role role)
	{
		this.role= role;
	}
	
	public Role getRole()
	{
		return this.role;
	}
}
