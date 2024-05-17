package org.vinit.datastructure.algoexpert.tries;

import java.util.*;

public class Hard_MultiSearchString {

    public static List<Boolean> multiStringSearch(
            String bigString, String[] smallStrings
    ) {
        // Write your code here.
        // TC: O(n + m.k) || SC: O(n)
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bigString.length(); i++) {
            if (!map.containsKey(bigString.charAt(i)))
                map.put(bigString.charAt(i), new ArrayList<>());
            map.get(bigString.charAt(i)).add(i);
        }
        System.out.println(map);

        List<Boolean> result = new ArrayList<>();
        for (String s : smallStrings) {
            Boolean exists = false;
            char startingChar = s.charAt(0);
            if (!map.containsKey(startingChar)) exists = false;
            else {
                List<Integer> allCharIndex = map.get(startingChar);
                if (allCharIndex.isEmpty()) exists = false;
                else {
                    for (Integer index : allCharIndex) {
                        Boolean res = isSubStringExist(index, s, bigString);
                        if (res) {
                            exists = res;
                            break;
                        }
                    }
                }
            }
            result.add(exists ? true : false);
        }

        return result;
    }

    private static Boolean isSubStringExist(int idx, String str, String bigString) {
        int i = idx;
        int j = 0;
        while (i < bigString.length() && j < str.length()) {
            if (bigString.charAt(i) != str.charAt(j)) return false;
            i++;
            j++;
        }
        return j == str.length();
    }

    public static void main(String[] args) {
        System.out.println(List.of(multiStringSearch("this is a big string", new String[]{"this", "yo", "is", "a", "bigger", "string", "kappa"})));
    }
}
