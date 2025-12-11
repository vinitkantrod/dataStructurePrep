package org.vinit.datastructure.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Easy_TournamentWinner {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        // Write your code here.
        // record score in hashMap and sort in desc O(n) + O(n)
        // Use MaxHeap = O(nlogn)
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                scoreMap.computeIfAbsent(competitions.get(i).get(0), k -> 0);
                scoreMap.put(competitions.get(i).get(0), scoreMap.get(competitions.get(i).get(0)) + 1);
            } else {
                scoreMap.computeIfAbsent(competitions.get(i).get(1), k -> 0);
                scoreMap.put(competitions.get(i).get(1), scoreMap.get(competitions.get(i).get(1)) + 1);
            }
        }
        int maxScore = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            if (entry.getValue() > maxScore) {
                winner = entry.getKey();
                maxScore = entry.getValue();
            }
        }
        return winner;
    }
}
