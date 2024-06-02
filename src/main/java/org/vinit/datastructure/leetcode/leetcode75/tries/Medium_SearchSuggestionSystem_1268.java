package org.vinit.datastructure.leetcode.leetcode75.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_SearchSuggestionSystem_1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // brute force
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0, right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char currentChar = searchWord.charAt(i);
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != currentChar)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != currentChar)) {
                right--;
            }
            List<String> suggestions = new ArrayList<>();
            for (int j = left; j < Math.min(left + 3, right + 1); j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }
        return result;
    }
}
