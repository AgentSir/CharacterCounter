package ua.sputilov.entities;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * The class represents an object that is able to group,
 * sort naturally and count characters in the string.
 *
 */
public class CharacterCounter {

    private final Comparator<Map.Entry<Character, Long>> sortKeysNaturally =
            Comparator.comparing(Map.Entry::getKey, Comparator.naturalOrder());

    /**
     * The method sorts and counts characters in the string passed as param.
     * @param str
     * @return Map<Character, Long> - sorted map of characters with count duplicates
     */
    public Map<Character, Long> sortAndCountCharacters(String str) {

        Stream<Character> characterStream = str.chars().mapToObj(i -> (char) i);
        Map<Character, Long> characterDuplicatesSortedMap;

        // grouping all characters with counting to the map
        characterDuplicatesSortedMap = characterStream
                .collect(groupingBy(chr -> chr, counting()));

        // sorting keys in the map in natural order
        characterDuplicatesSortedMap = characterDuplicatesSortedMap.entrySet().stream()
                .sorted(sortKeysNaturally)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k1, k2) -> {
                            // throwingMerger() throws IllegalStateException
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        LinkedHashMap::new
                ));;

        return characterDuplicatesSortedMap;
    }

    /**
     * The method builds string representation of a map that passes as param
     * @param map map to build string
     * @return - concatenated keys and values into string without any separators
     */
    public String mapToString(Map<Character, Long> map) {

        String result = map.entrySet().stream()
                .map(entry -> entry.getKey().toString() + entry.getValue())
                .collect(joining());

        return result;
    }
}
