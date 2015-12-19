package game_resources;

import game_resources.processing.Compressor;
import game_resources.processing.RandomizedData;
import game_resources.processing.RandomizedName;

/**
 * Created by Matthew on 12/18/2015.
 */
public class PopulateDatabase {

    public static void main(String[] args) {

        RandomizedData randomizedData = new RandomizedData();
        Compressor compressor = new Compressor();
        RandomizedName randomizedName = new RandomizedName();

        for (int i = 0; i < 10; i++) {

            String[] data = randomizedData.generateRandomWordListData();
            int list = compressor.process(data);

            for (int j = 0; j < 10; j++) {

                Integer[] moreData = randomizedData.generateRandomGameSessionData();
                compressor.process(moreData, list, randomizedName.generateRandomName());

            }

        }

    }

}
