package game_resources.processing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class RandomizedName {

    public String generateRandomName() {

        URL characterURL;
        BufferedReader reader;
        String line;
        Random random = new Random();
        String randomName = "";

        try {

            characterURL = new URL("https://www.random.org/strings/?num=2&len=1&upperalpha=on&unique=on&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(characterURL.openStream()));

            while ((line = reader.readLine()) != null) {

                randomName += getMilitaryPhoneticString(line);

            }

            randomName += (random.nextInt(10000) + 1);

        } catch (Exception e) {

            System.out.println("Random name generation by internet has failed. Generating a name by server-side instead.");

            char aChar;
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            randomName = "";

            for (int i = 0; i < 2; i++) {

                aChar = alphabet.charAt(random.nextInt(alphabet.length()));
                randomName += getMilitaryPhoneticString(String.valueOf(aChar));

            }

            randomName += (random.nextInt(10000) + 1);

        }

        return randomName;

    }

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
