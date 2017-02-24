package com.algorithms.random;

import java.util.*;

/**
 * Given a string, , we define some operations on the string as follows:
 * <p/>
 * a. reverse(S) denotes the string obtained by reversing string . E.g.: reverse("abc") = "cba"
 * <p/>
 * b. shuffle(S) denotes any string that's a permutation of string . E.g.: shuffle("god") ? ['god', 'gdo', 'ogd', 'odg', 'dgo', 'dog']
 * <p/>
 * c. merge(S1,S2) denotes any string that's obtained by interspersing the two strings  & , maintaining the order of characters in both.
 * E.g.: S1 = "abc" & S2 = "def", one possible result of merge(S1,S2) could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.
 * <p/>
 * Given a string  such that  merge(reverse(A), shuffle(A)), for some string , can you find the lexicographically smallest ?
 * <p/>
 * Input Format
 * <p/>
 * A single line containing the string .
 * <p/>
 * Constraints:
 * <p/>
 * contains only lower-case English letters.
 * The length of string  is less than or equal to .
 * <p/>
 * Output Format
 * <p/>
 * A string which is the lexicographically smallest valid .
 * <p/>
 * Sample Input
 * <p/>
 * eggegg
 * <p/>
 * Sample Output
 * <p/>
 * egg
 * <p/>
 * Explanation
 * <p/>
 * reverse("egg") = "gge"
 * shuffle("egg") can be "egg"
 * "eggegg" belongs to merge of ("gge", "egg")
 * <p/>
 * The split is: e(gge)gg.
 * <p/>
 * egg is the lexicographically smallest.
 * TODO: Incomplete
 */
public class ReverseShuffleMerge {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String element = scanner.nextLine();
        System.out.println(lexicographicallySmallest(element));
        */
        String element = "bdabaceadaedaaaeaecdeadababdbeaeeacacaba";
        String expectedResult = "aaaaaabaaceededecbdb";
        System.out.println(expectedResult.length());
        System.out.println(expectedResult.equals(lexicographicallySmallest(element)));
        System.out.println(lexicographicallySmallest(element));
        System.out.println(findSmallestGroup(element));
        System.out.println(findSmallestGroup(element).length());
        System.out.println(shuffleSet(findSmallestGroup(element)));
        System.out.println(shuffleSet(findSmallestGroup(element)).contains(expectedResult));
        System.out.println(lexographicallyOrderSet(shuffleSet(findSmallestGroup(element))));
    }

    public static String lexicographicallySmallest(String element) {
        String smallestGroup = findSmallestGroup(element);
        List<String> setOfShuffle = lexographicallyOrderSet(shuffleSet(smallestGroup));
        for (String shuffleOfSmallestGroup : setOfShuffle) {
            if (containsGroup(element, reverse(shuffleOfSmallestGroup))) {
                return shuffleOfSmallestGroup;
            }
        }
        return "";
    }

    public static List<String> lexographicallyOrderSet(Set<String> elements) {
        List<String> list = new ArrayList<>(elements);
        Collections.sort(list);
        return list;
    }

    public static boolean containsGroup(String element, String group) {
        String aux = element;
        for (int i = 0; i < group.length(); i++) {
            String character = String.valueOf(group.charAt(i));
            if (aux.contains(character)) {
                aux = aux.substring(aux.indexOf(character) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    private static String findSmallestGroup(String element) {
        String res = "";
        for (int i = 0; i < element.length(); i++) {
            char character = element.charAt(i);
            String characterStr = String.valueOf(character);
            if (res.contains(String.valueOf(character))) {
                continue;
            }
            int numberOfElements = numberOfElements(element, character);
            if (numberOfElements % 2 != 0) {
                return null;
            }
            res += multiplyChar(numberOfElements / 2, characterStr);
        }
        return res;
    }

    public static Set<String> shuffleSet(String element) {
        Set<String> results = doShuffleSet(element);
        results.addAll(doShuffleSet(reverse(element)));
        return results;
    }

    public static Set<String> doShuffleSet(String element) {
        Set<String> elements = new HashSet<>();
        for (int i = 0; i < element.length(); i++) {
            String characterStr = String.valueOf(element.charAt(i));
            String restOfElement = element.substring(0, Math.max(i, 0)) + element.substring(i + 1);
            for (int j = 0; j < restOfElement.length(); j++) {
                String aux = restOfElement.substring(0, Math.max(j, 0)) + characterStr + restOfElement.substring(j);
                if (!elements.contains(aux)) {
                    elements.add(aux);
                }
            }
        }
        return elements;
    }

    public static String reverse(String element) {
        if (element == null) {
            return null;
        }
        return new StringBuffer(element).reverse().toString();
    }

    public static int numberOfElements(String input, char element) {
        int result = 0;
        String aux = input;
        int idx = aux.indexOf(element);
        while (idx >= 0) {
            ++result;
            aux = aux.substring(idx + 1);
            idx = aux.indexOf(element);
        }
        return result;
    }

    private static String multiplyChar(int numberOfTimes, String character) {
        return new String(new char[numberOfTimes]).replace("\0", character);
    }
}
