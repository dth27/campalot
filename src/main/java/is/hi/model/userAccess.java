package is.hi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * userAccess klasi sem inniheldur notendaupplýsingar
 */
@Entity
@Table (name="useraccess")
public class userAccess {
    @Id
    String username;
    String email;
    String password;
    boolean hasaccess;
    boolean hasadminauthority;

    public userAccess(String username, String email, String password, boolean hasaccess, boolean hasadminauthority) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.hasaccess = hasaccess;
        this.hasadminauthority = hasadminauthority;
    }

    public userAccess() {
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
    public boolean isHasaccess() {
        return hasaccess;
    }

    public void setHasaccess(boolean hasAccess) {
        this.hasaccess = hasAccess;
    }

    public boolean isHasadminauthority() {
        return hasadminauthority;
    }

    public void setHasadminauthority(boolean hasAdminAuthority) {
        this.hasadminauthority = hasAdminAuthority;
    }

}
