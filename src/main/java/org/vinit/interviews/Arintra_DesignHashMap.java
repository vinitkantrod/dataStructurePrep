package org.vinit.interviews;

/**
 * Design Hash Map to support String Key Value pair with
 * put, get, remove operation
 * PUT: O(1)
 * GET: O(1)
 * REMOVE: O(1)
 */
public class Arintra_DesignHashMap {

    public static void main(String[] args) {
        CustomHashMap cm = new CustomHashMap();
        cm.put("One", "1");
        cm.put("Two", "22");
        cm.put("Three", "3");
        System.out.println(cm.get("Four"));
        System.out.println(cm.get("Two"));
        cm.remove("Two");
        System.out.println(cm.get("Two"));
        System.out.println(cm.get("One"));
        cm.put("One", "11");
        System.out.println(cm.get("One"));
    }

    static class Node {
        String key;
        String val;
        public Node(String _key, String _val) {
            this.key = _key;
            this.val = _val;
        }
    }

    static class LinkedList {

    }
    static class CustomHashMap {
        Node[] map;
        final int SIZE;
        public CustomHashMap() {
            SIZE = 769;
            map = new Node[SIZE];
        }
        private int hash(String key) {
            return key.hashCode() % SIZE;
        }
        public void put(String _k, String _v) {
            int loc = this.hash(_k);
            Node node = new Node(_k, _v);
            map[loc] = node;
        }

        // If String exist then return value else return null;
        public String get(String _key) {
            int loc = this.hash(_key);
            if (map[loc] != null) return map[loc].val;
            else return null;
        }

        // Do nothing in case of no key found
        public void remove(String _key) {
            int loc = this.hash(_key);
            if (map[loc] != null) map[loc] = null;
        }
    }
}
