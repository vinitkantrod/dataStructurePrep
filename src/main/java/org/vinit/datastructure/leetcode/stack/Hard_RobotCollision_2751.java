package org.vinit.datastructure.leetcode.stack;

import java.util.*;

public class Hard_RobotCollision_2751 {

//    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//        Stack<int[]> rightStack = new Stack<>();
//        Stack<int[]> leftStack = new Stack<>();
//        int maxXValue = Integer.MIN_VALUE;
//        for (int i = 0; i < positions.length; i++) {
//            maxXValue = Math.max(maxXValue, positions[i]);
//        }
//        System.out.println(maxXValue);
//        int[] newPosition = new int[maxXValue + 1];
//        Arrays.fill(newPosition, -1);
//        System.out.println(Arrays.toString(newPosition));
//        for (int i : positions) {
//            newPosition[i - 1] = healths[i];
//            i++;
//        }
//        for (int i = 0; i < positions.length; i++) {
//            if (directions.charAt(i) == 'R') {
//                rightStack.push(new int[]{healths[i], i});
//            } else {
//                if (rightStack.isEmpty()) {
//                    leftStack.push(new int[]{healths[i], i});
//                } else {
//                    if (rightStack.peek()[0] == healths[i]) {
//                        rightStack.pop();
//                    } else if (rightStack.peek()[0] > healths[i]) {
//                        int[] d = rightStack.pop();
//                        d[0] = d[0] - 1;
//                        rightStack.push(d);
//                    } else {
//                        rightStack.pop();
//                        leftStack.push(new int[]{healths[i] - 1, i});
//                    }
//                }
//            }
//        }
//        LinkedList<Integer> result = new LinkedList<>();
//        while (!rightStack.isEmpty() || !leftStack.isEmpty()) {
//            if (rightStack.peek()[1] > leftStack.peek()[1]) {
//                result.addFirst(rightStack.pop()[1]);
//            } else {
//                result.addFirst(leftStack.pop()[1]);
//            }
//        }
//        System.out.println(Arrays.asList(result));
//        return result;
//    }

    public static List<Integer> survivedRobotsHealths(
            int[] positions,
            int[] healths,
            String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
                indices,
                (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] p = new int[]{5,4,3,2,1};
        int[] h = new int[]{2,17,9,15,10};
        System.out.println(survivedRobotsHealths(p, h, "RRRRR"));
//        p = new int[]{3,5,2,6};
//        h = new int[]{10,10,15,12};
//        System.out.println(survivedRobotsHealths(p, h, "RLRL"));
    }
}
