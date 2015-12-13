package game_resources.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decompressor {

    private String filePath;

    public Integer[] processGameSession(String filePath) {

        Integer[] array;
        Object[] tempArray;

        this.filePath = filePath;
        tempArray = readFile();
        array = Arrays.copyOf(tempArray, tempArray.length, Integer[].class);

        return array;

    }

    public String[] processWordList(String filePath) {

        String[] array;
        Object[] tempArray;

        this.filePath = filePath;
        tempArray = readFile();
        array = Arrays.copyOf(tempArray, tempArray.length, String[].class);

        return array;

    }

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