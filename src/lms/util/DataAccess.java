package lms.util;

public class DataAccess {

    public static Auth login(String id, String pwd) {
        Auth auth = new Auth();
        if (id.equals("libadmin") && pwd.equals("libadmin")) {
            auth.setUserName("libadmin");
            auth.setPassword("libadmin");
            auth.setRole(Role.ROLE_ADMIN_LIBRARIAN);
        } else if (id.equals("admin") && pwd.equals("admin")) {
            auth.setUserName("admin");
            auth.setPassword("admin");
            auth.setRole(Role.ROLE_ADMINISTRATOR);
        } else if (id.equals("lib") && pwd.equals("lib")) {
            auth.setUserName("lib");
            auth.setPassword("lib");
            auth.setRole(Role.ROLE_LIBRARIAN);
        } else
            auth = null;

        return auth;
    }
}
