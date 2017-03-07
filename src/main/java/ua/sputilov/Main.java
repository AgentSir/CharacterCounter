package ua.sputilov;

import ua.sputilov.entities.CharacterCounter;
import ua.sputilov.entities.UserInterface;

import java.util.Map;

/**
 * The main class
 */
public class Main {

    public static void main(String[] args) {

        String strToProcess = "";
        String result = "";
        Map<Character, Long> sortedAndCountedCharacters;

        UserInterface userInterface = new UserInterface();
        strToProcess = userInterface.getStringToProcess();

        CharacterCounter charCounter = new CharacterCounter();
        sortedAndCountedCharacters = charCounter.sortAndCountCharacters(strToProcess);

        result = charCounter.mapToString(sortedAndCountedCharacters);

        userInterface.printResult(result);
    }
}
