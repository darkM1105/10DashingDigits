package game_resources.processing;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedData {

    private Random random = new Random();
    private BufferedReader reader;
    private URL url;

    public Integer[] generateRandomGameSessionData() {

        List<Integer> tempArray = new ArrayList<Integer>();
        String line;

        try {

            url = new URL("https://www.random.org/integers/?num=270&min=50&max=1000&col=1&base=10&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {

                tempArray.add(Integer.valueOf(line));

            }

        } catch (Exception e) {

            System.out.println("Random game session generation by internet has failed. Generating a game session by server-side instead.");

            for (int i = 1; i <= 270; i++) {

                tempArray.add(random.nextInt(951) + 50);

            }

        }

        Integer[] array = tempArray.toArray(new Integer[tempArray.size()]);

        return array;

    }

    public String[] generateRandomWordListData() {

        List<String> tempArray = new ArrayList<String>();
        String line;

        try {

            url = new URL("https://www.random.org/strings/?num=30&len=6&digits=on&upperalpha=on&loweralpha=on&unique=off&format=plain&rnd=new");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {

                tempArray.add(line + " ");

            }

        } catch (Exception e) {

            System.out.println("Random word list generation by internet has failed. Generating a word list by server-side instead.");

            String alphabet = "Aa0BbCc1DdEe2FfGg3HhIi4JjKk5LlMm6NnOo7PpQq8RrSs9TtUuVvWwXxYyZz";

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

        return array;

    }

}