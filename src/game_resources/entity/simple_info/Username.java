package game_resources.entity.simple_info;

/**
 * A very simple method used to store and publicly share the user's username.
 *
 * @author mrclark@madisoncollege.edu
 */
public class Username {

    private static Username userName = new Username();
    private static String username;

    public static String getUsername() {

        return username;

    }

    public static void setUsername(String username) {

        Username.username = username;

    }

}
