package org.vinit.datastructure.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Hard_RobotRoomCleaner_489 {

    interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
              // Returns false if the cell in front is blocked and robot stays in the current cell.
              public boolean move();

              // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
      public void turnRight();

              // Clean the current cell.
              public void clean();
 }
    int[][] directions;
    Set<String> visited;

    public void cleanRoom(Robot robot) {
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left-clockwise
        visited = new HashSet<>(); // DFS visited DS
        dfs(robot, 0, 0, 0); // Start from row 0 col 0 direction 0
    }
    private void dfs(Robot robot, int row, int col, int dir) {
        robot.clean(); // Clean the current cell
        visited.add(row + "_" + col); // Mark the current cell visited
        for (int i = 0; i < 4; i++) { // Explore 4 different directions
            int newDir = (dir + i) % 4; // Next direction 0,1,2,3
            int newI = row + directions[newDir][0]; // New cell row
            int newJ = col + directions[newDir][1]; // New cell column
            if (!visited.contains(newI + "_" + newJ) && robot.move()) { // If cell not visited and not blocked
                dfs(robot, newI, newJ, newDir); // Explore the new cell
                // Go back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                // Turn the head to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); // Explore the next direction-total 4 directions
        }
    }
}
