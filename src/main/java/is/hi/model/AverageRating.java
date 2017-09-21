package is.hi.model;

/**
 * @author Diljá, Ólöf, Sandra og Kristín
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * AverageRating klasi sem inniheldur upplýsingar um hve margir hafa gefið rating
 * og hver einkunnin sé
 */

public class AverageRating {
    int totalPeopleVoted;
    int totalScoreGiven;

    public int getTotalPeopleVoted() {
        return totalPeopleVoted;
    }

    public void setTotalPeopleVoted(int totalPeopleVoted) {
        this.totalPeopleVoted = totalPeopleVoted;
    }

    public int getTotalScoreGiven() {
        return totalScoreGiven;
    }

    public void setTotalScoreGiven(int totalScoreGiven) {
        this.totalScoreGiven = totalScoreGiven;
    }
}
