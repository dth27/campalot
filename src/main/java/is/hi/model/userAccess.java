package is.hi.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * userAccess cass that holds informaion about user
 */
@Entity
@Table (name="useraccess")
public class userAccess {
    @Id
    @NotNull
    @Size(min = 4, max = 10)
    private String username;

    @NotNull
    @Email
    @Size(min = 6, max = 50)
    private String email;

    @NotNull
    @Size(min = 1, max = 15)
    private String password;

    private boolean hasaccess;
    private boolean hasadminauthority;

    public userAccess(String username, String email, String password, boolean hasaccess, boolean hasadminauthority) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.hasaccess = hasaccess;
        this.hasadminauthority = hasadminauthority;
    }

    public userAccess() {
    }

    /*@OneToMany(orphanRemoval = false, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = true)
    private Set<Review> review;*/

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
