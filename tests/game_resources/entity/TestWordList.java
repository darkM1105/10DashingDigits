package game_resources.entity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestWordList {

    WordList wordList;

    @Test
    public void testInstantiateWordListWithoutParameters() {
        wordList = new WordList();
        assertNotNull(wordList);
    }

    @Test
    public void testInstantiateWordListWithParameters() {
        wordList = new WordList(0, null);
        assertNotNull(wordList);
    }

    @Test
    public void testWordListToString() {
        wordList = new WordList(0, "");
        String actualString = wordList.toString();
        String expectedString = "listId: 0; filePath: ";
        assertEquals("Testing the 'WordList' toString() method.", expectedString, actualString);
    }

}
