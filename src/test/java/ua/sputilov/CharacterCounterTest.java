package ua.sputilov;

import org.junit.Test;
import java.util.Map;
import ua.sputilov.entities.CharacterCounter;

import static org.junit.Assert.assertEquals;

public class CharacterCounterTest {

    private Map<Character, Long> sortedAndCountedCharactersMap;

    private String testString = "adasdasadasdgeg";
    private String expectedResult = "a5d4e1g2s3";

    @Test
    public void sortAndCountCharactersTest() {

        CharacterCounter characterCounter = new CharacterCounter();
        sortedAndCountedCharactersMap = characterCounter.sortAndCountCharacters(testString);

        String result = characterCounter.mapToString(sortedAndCountedCharactersMap);

        assertEquals(expectedResult, result);
    }
}
