package is.hi.repository;

import is.hi.model.loginUser;

import java.util.List;

/**
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * @author Diljá, Ólöf, Sandra, Kristín
 *
 * repository for all login users
 */
public interface userRepository {
    /**
     * retrieves all login users
     * @return list of login users
     */
    List <loginUser> getAll();

    /**
     * adds loginUser
     * @param loginUser
     */
    void add(loginUser loginUser);
    String getReviews(String username);
}
