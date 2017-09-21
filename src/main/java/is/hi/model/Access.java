package is.hi.model;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * Access klasi inniheldur upplýsingar um hvernig aðgang notandi hefur
 */

public class Access {
    boolean hasAccess;
    boolean hasAdminAuthority;

    public boolean isHasAccess() {
        return hasAccess;
    }

    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    public boolean isHasAdminAuthority() {
        return hasAdminAuthority;
    }

    public void setHasAdminAuthority(boolean hasAdminAuthority) {
        this.hasAdminAuthority = hasAdminAuthority;
    }
}
