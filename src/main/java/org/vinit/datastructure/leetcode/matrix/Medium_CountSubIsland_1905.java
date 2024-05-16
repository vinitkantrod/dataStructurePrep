package org.vinit.datastructure.leetcode.matrix;

import java.util.ArrayList;

public class Medium_CountSubIsland_1905 {

    static int[] xDir = {0,0,-1,1};
    static int[] yDir = {-1,1,0,0};

    static class Pair
    {
        int x = 0;
        int y = 0;
        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if(grid2[i][j] == 1 && visited[i][j] == false)
                {
                    ArrayList<Pair> arr = new ArrayList<>();
                    DFS(grid2,visited,i,j,arr);
                    boolean flag = false;
                    for(Pair p : arr)
                    {
                        int x = p.x;
                        int y = p.y;
                        if(grid1[x][y] != 1)
                        {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                        count++;
                }
            }
        }
        return count;
    }
    public static void DFS(int[][] grid2, boolean[][] visited, int i, int j, ArrayList<Pair> arr)
    {
        if(i<0 || i>=grid2.length || j<0 || j>=grid2[0].length || visited[i][j] == true ||grid2[i][j]!=1)
            return;
        visited[i][j] = true;
        Pair p = new Pair(i,j);
        arr.add(p);
        for(int k = 0;k<4;k++)
        {
            int newRow = i+xDir[k];
            int newCol = j+yDir[k];
            DFS(grid2,visited,newRow,newCol,arr);
        }
    }

    public static void main(String[] args) {
//        System.out.println(countSubIslands(
//                new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
//                new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}
//        ));
        System.out.println(countSubIslands(
                new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}
        ));
    }
}
