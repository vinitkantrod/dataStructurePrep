package org.vinit.datastructure.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_FindAllGroupsOfFarmLand_1992 {
    static List<Integer[]> coordinates = new ArrayList<>();
    public static int[][] findFarmland(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    Integer[] currCoordinates = new Integer[]{-1,-1,-1,-1};
                    dfs(i, j, land, currCoordinates);
                    for (int k = 0; k < land.length; k++) System.out.println(Arrays.toString(land[k]));
                    System.out.println("-------------");
                    coordinates.add(currCoordinates);
                }
            }
        }
        int[][] res = new int[coordinates.size()][4];
        for (int i = 0; i < coordinates.size(); i++) {
            Integer[] t = coordinates.get(i);
            res[i] = new int[]{t[0], t[1], t[2], t[3]};
        }
        return res;
    }
    private static void dfs(int i, int j, int[][] land, Integer[] currLand) {
        if (i < 0 || j < 0 || i == land.length || j == land[0].length) return;
        if (land[i][j] == 0 || land[i][j] == -1) return;
        land[i][j] = -1;
        System.out.println("i: " + i + ", j: " + j);
        if (currLand[0] == -1) {
            currLand[0] = i;
            currLand[1] = j;
            currLand[2] = i;
            currLand[3] = j;
        } else if (currLand[2] < i || currLand[3] < j) {
            currLand[2] = i;
            currLand[3] = j;
        }
        System.out.println(Arrays.toString(currLand));
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] dir : directions) {
            dfs(i + dir[0], j + dir[1], land, currLand);
        }
    }

    public static void main(String[] args) {
        int[][] r = findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}});
    }
}
