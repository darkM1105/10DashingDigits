package game_resources.processing;

//import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that generates random raw data for either a new 'GameSession' or 'WordList' object.
 *
 * @author mrclark@madisoncollege.edu
 */
public class RandomizedData {
    //private final Logger logger = Logger.getLogger(this.getClass());

    private Random random = new Random();
    private BufferedReader reader;
    private URL url;

    /**
     * Method that makes a request to 'random.org' and receives a string of 270 integers.
     *
     * @return      A full array that is necessary for a new 'GameSession' object.
     */
    public Integer[] generateRandomGameSessionData() {

        List<Integer> tempArray = new ArrayList<>();
        String line;

        //logger.info("Generating random game session data.");

        try {

            url = new URL("https://www.random.org/integers/?num=210&min=50&max=1000&col=1&base=10&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {

                tempArray.add(Integer.valueOf(line));

            }

          //If the web request fails in any way, a server-side randomly generated array will be created instead.
        } catch (Exception e) {

            //logger.info("Random game session generation by internet has failed. Generating a game session by server-side instead.");

            for (int i = 1; i <= 270; i++) {

                tempArray.add(random.nextInt(951) + 50);

            }

        }

        Integer[] array = tempArray.toArray(new Integer[tempArray.size()]);

        //logger.info("Array size: " + array.length);

        return array;

    }

    /**
     * Method that makes a request to 'random.org' and receives a string of 30 strings that are 6 characters long each.
     *
     * @return      A full array that is necessary for a new 'WordList' object.
     */
    public String[] generateRandomWordListData() {

        List<String> tempArray = new ArrayList<>();
        String line;

        //logger.info("Generating random word list data.");

        try {

            url = new URL("https://www.random.org/strings/?num=30&len=6&loweralpha=on&unique=off&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {

                tempArray.add(line + " ");

            }

          //If the web request fails in any way, a server-side randomly generated array will be created instead.
        } catch (Exception e) {

            //logger.info("Random word list generation by internet has failed. Generating a word list by server-side instead.");

            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < 30; i++) {

                String tempString = "";

                for (int j = 0; j < 6; j++) {

                    tempString += alphabet.charAt(random.nextInt(alphabet.length()));

                }

                tempString += " ";
                tempArray.add(tempString);

            }

        }

        String[] array = tempArray.toArray(new String[tempArray.size()]);

        //logger.info("Array size: " + array.length);

        return array;

    }

}