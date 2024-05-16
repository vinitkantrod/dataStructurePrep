package org.vinit.datastructure.leetcode.array;

import java.util.*;

public class Medium_KeysAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        if (rooms.isEmpty()) return true;
        Queue<Integer> queue = new LinkedList<>(rooms.get(0));
        visited.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (visited.contains(vertex)) continue;
            queue.addAll(rooms.get(vertex));
            visited.add(vertex);
        }
        return visited.size() == rooms.size();
    }
}
