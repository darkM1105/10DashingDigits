package game_resources.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that reads a given file and outputs the raw data from the file.
 *
 * @author mrclark@madisoncollege.edu
 */
public class Decompressor {

    private String filePath;

    /**
     * Method that reads the 'GameSession' file of the corresponding filepath.
     *
     * @param filePath  The filepath of the file to be read.
     * @return      An Integer array representing all raw data from read file.
     */
    public Integer[] processGameSession(String filePath) {

        Integer[] array;
        Object[] tempArray;

        this.filePath = filePath;
        tempArray = readFile();
        array = new Integer[tempArray.length];

        for (int i = 0; i < tempArray.length; i++) {

            array[i] = Integer.valueOf((String) tempArray[i]);

        }

        return array;

    }

    /**
     * Method that reads the 'WordList' file of the corresponding filepath.
     *
     * @param filePath  The filepath of the file to be read.
     * @return      An String array representing all raw data from read file.
     */
    public String[] processWordList(String filePath) {

        String[] array;
        Object[] tempArray;

        this.filePath = filePath;
        tempArray = readFile();
        array = Arrays.copyOf(tempArray, tempArray.length, String[].class);

        return array;

    }

    /**
     * Method that actually reads the file.
     *
     * @return      An object array that will be converted to the return value of the method that called it.
     */
    private Object[] readFile() {

        List<Object> tempArray = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while (reader.ready()) {

                line = reader.readLine();

                for (String object: line.split(" ")) {

                    tempArray.add(object);

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        Object[] array =  tempArray.toArray(new Object[tempArray.size()]);

        return array;

    }

}