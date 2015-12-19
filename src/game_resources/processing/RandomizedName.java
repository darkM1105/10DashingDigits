package game_resources.processing;

//import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

/**
 * A class that generates a random optional username.
 *
 * @author mrclark@madisoncollege.edu
 */
public class RandomizedName {
    //private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method that makes a request to 'random.org' and generates a username based of it's response.
     *
     * @return  A string representing the optional username.
     */
    public String generateRandomName() {

        URL characterURL;
        BufferedReader reader;
        String line;
        Random random = new Random();
        String randomName = "";

        //logger.info("Generating random name.");

        try {

            //Retrieves 2 different characters and generates a username based off of them.
            characterURL = new URL("https://www.random.org/strings/?num=2&len=1&upperalpha=on&unique=on&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(characterURL.openStream()));

            while ((line = reader.readLine()) != null) {

                randomName += getMilitaryPhoneticString(line);

            }

            //Throw on a random number for good measure.
            randomName += (random.nextInt(10000) + 1);

          //If the web request fails in any way, a server-side randomly generated username will be created instead.
        } catch (Exception e) {

            //logger.info("Random name generation by internet has failed. Generating a name by server-side instead.");

            char aChar;
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            randomName = "";

            for (int i = 0; i < 2; i++) {

                aChar = alphabet.charAt(random.nextInt(alphabet.length()));
                randomName += getMilitaryPhoneticString(String.valueOf(aChar));

            }

            randomName += (random.nextInt(10000) + 1);

        }

        //logger.info("Random name: " + randomName);

        return randomName;

    }

    /**
     * Method that converts a character to it's military phonetic equivalent.
     *
     * @param aChar     A string to be converted.
     * @return  The military phonetic equivalent to the passed in character.
     */
    private String getMilitaryPhoneticString(String aChar) {

        String militaryPhoneticString = "";

        switch (aChar) {

            case "A" :

                militaryPhoneticString = "Alfa";
                break;

            case "B" :

                militaryPhoneticString = "Bravo";
                break;

            case "C" :

                militaryPhoneticString = "Charlie";
                break;

            case "D" :

                militaryPhoneticString = "Delta";
                break;

            case "E" :

                militaryPhoneticString = "Echo";
                break;

            case "F" :

                militaryPhoneticString = "Foxtrot";
                break;

            case "G" :

                militaryPhoneticString = "Golf";
                break;

            case "H" :

                militaryPhoneticString = "Hotel";
                break;

            case "I" :

                militaryPhoneticString = "India";
                break;

            case "J" :

                militaryPhoneticString = "Juliett";
                break;

            case "K" :

                militaryPhoneticString = "Kilo";
                break;

            case "L" :

                militaryPhoneticString = "Lima";
                break;

            case "M" :

                militaryPhoneticString = "Mike";
                break;

            case "N" :

                militaryPhoneticString = "November";
                break;

            case "O" :

                militaryPhoneticString = "Oscar";
                break;

            case "P" :

                militaryPhoneticString = "Papa";
                break;

            case "Q" :

                militaryPhoneticString = "Quebec";
                break;

            case "R" :

                militaryPhoneticString = "Romeo";
                break;

            case "S" :

                militaryPhoneticString = "Sierra";
                break;

            case "T" :

                militaryPhoneticString = "Tango";
                break;

            case "U" :

                militaryPhoneticString = "Uniform";
                break;

            case "V" :

                militaryPhoneticString = "Victor";
                break;

            case "W" :

                militaryPhoneticString = "Whiskey";
                break;

            case "X" :

                militaryPhoneticString = "Xray";
                break;

            case "Y" :

                militaryPhoneticString = "Yankee";
                break;

            case "Z" :

                militaryPhoneticString = "Zulu";
                break;

        }

        return militaryPhoneticString;

    }

}
