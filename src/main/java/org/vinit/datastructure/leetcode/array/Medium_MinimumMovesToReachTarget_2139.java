package org.vinit.datastructure.leetcode.array;

public class Medium_MinimumMovesToReachTarget_2139 {

    public static int minMoves(int target, int maxDoubles) {
        int c=0;
        while(maxDoubles!=0 && target!=1) {
            if(target%2!=0) {
                c++;
                target-=1;
            }
            target=target/2;
            c++;
            maxDoubles--;
        }
        if(target!=1) c+=target-1;
        return c;
//        if (target == 1) return 0;
//        int starting = 1;
//        return countMoves(starting, target, 0, maxDoubles);
    }
    private static int countMoves(int curr, int target, int steps, int maxDoubles) {
//        System.out.println("Curr: " + curr + ", steps: " + steps + ", DC: " + maxDoubles + ", T: " + target );
        if (curr > target) return Integer.MAX_VALUE;
        if (curr == target) return steps;
        int doubleSteps = Integer.MAX_VALUE;
        if (maxDoubles > 0) {
            doubleSteps = countMoves(curr * 2, target, steps + 1, maxDoubles - 1);
        }
        int singleSteps = countMoves(curr + 1, target, steps + 1, maxDoubles);
        return Math.min(doubleSteps, singleSteps);
    }

    public static void main(String[] args) {
        System.out.println(minMoves(5, 0));
        System.out.println(minMoves(19, 2));
        System.out.println(minMoves(10, 4));
    }

}
