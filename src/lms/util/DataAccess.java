package lms.util;

public class DataAccess {

	public static Auth login(String id, String pwd) {
		Auth auth = new Auth();
		if(id == "ADMIN" && pwd == "ADMIN")
		{
			auth.setUserName("ADMIN");
			auth.setPassword("ADMIN");
			auth.setRole(Role.ROLE_ADMIN_LIBRARIAN);
		}
		else
			auth = null;
		
		return auth;
	}
}
