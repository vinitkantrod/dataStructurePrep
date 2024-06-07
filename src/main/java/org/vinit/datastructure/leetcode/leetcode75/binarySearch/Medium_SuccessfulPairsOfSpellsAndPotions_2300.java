package org.vinit.datastructure.leetcode.leetcode75.binarySearch;

import java.util.Arrays;

public class Medium_SuccessfulPairsOfSpellsAndPotions_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
//        int m = spells.length, n = potions.length;
//        int[][] sortedSpells = new int[m][2];
//        for (int i = 0; i < m; i++) {
//            sortedSpells[i][0] = spells[i];
//            sortedSpells[i][1] = i;
//        }
//        Arrays.sort(sortedSpells, (a,b) -> a[0] - b[0]);
//        Arrays.sort(potions);
//        int potionIndex = m - 1;
//        int[] answer = new int[m];
//        for (int[] sortedSpell : sortedSpells) {
//            int spell = sortedSpell[0];
//            int index = sortedSpell[1];
//            while (potionIndex >= 0 && (long) (spell * potions[potionIndex]) >= success)
//                potionIndex-= 1;
//            answer[index] = n - (potionIndex + 1);
//        }
//        return answer;
        int n = spells.length;
        int m = potions.length;

        // Create an array of pairs containing spell and its original index
        int[][] sortedSpells = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }

        // Sort the 'spells with index' and 'potions' array in increasing order
        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);

        // For each 'spell' find the respective 'minPotion' index
        int[] answer = new int[n];
        int potionIndex = m - 1;

        for (int[] sortedSpell : sortedSpells) {
            int spell = sortedSpell[0];
            int index = sortedSpell[1];

            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex -= 1;
            }
            answer[index] = m - (potionIndex + 1);
        }

        return answer;
    }
}
