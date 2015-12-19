package game_resources.entity.simple_info;

/**
 * Class created as a surefire way to make sure that information gets returned for the admin page.
 *
 * @author mrclark@madisoncollege.edu
 */
public class TrueCount {

    private int trueCount;

    public int getTrueCount() {

        return trueCount;

    }

    public void setTrueCount(int trueCount) {

        this.trueCount = trueCount;

    }

    public TrueCount() {}

    public TrueCount(int trueCount) {

        this.trueCount = trueCount;

    }

    public String toString() {

        return "trueCount: " + trueCount;

    }

}
