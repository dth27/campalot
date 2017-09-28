package is.hi.model;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * loginUser klasi sem inniheldur notendaupplýsingar
 */

public class loginUser {
    String username;
    String email;
    String password;
    Boolean adminAuth;
    
    public loginUser(String username, String email, String password, Boolean adminAuth) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.adminAuth = adminAuth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getadminAuth() { return adminAuth; }

    public void setAdminAuth(Boolean adminAuth) { this.adminAuth = adminAuth; }
}

