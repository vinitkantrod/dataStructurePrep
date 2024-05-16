package org.vinit.interviews;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Transactional Key Value store:
 * O(1) - add, get, delete
 *
 */
public class TechRound  {

    interface MainMapi {
        public Boolean createTrasaction(String transactionKey);
        public Boolean commitTrasaction(String transactionKey);
        public Boolean rollbackTrasaction(String transactionKey);
        public void insert(String key, String value);
        public Boolean delete(String key);
        public String getValue(String key);
    }

    static class MainMap implements MainMapi {
        Map<String, String> map;
        Map<String, String> transactionMap;
        String transactionKey;
        Set<String> deletedKey;

        public MainMap() {
            map = new HashMap<>();
            transactionKey = "";
        }
        @Override
        public Boolean createTrasaction(String _transactionKey) {
            transactionKey = _transactionKey;
            transactionMap = new HashMap<>();
            deletedKey = new HashSet<>();
            return true;
        }

        @Override
        public Boolean commitTrasaction(String _transactionKey) {
            if (!transactionKey.equals(_transactionKey)) return false;
            for (Map.Entry<String, String> record : transactionMap.entrySet()) {
                if (deletedKey.contains(record.getKey())) {
                    map.remove(record.getKey());
                    deletedKey.remove(record.getKey());
                } else map.put(record.getKey(), record.getValue());
            }
            deletedKey = new HashSet<>();
            transactionMap = new HashMap<>();
            transactionKey = "";
            return true;
        }

        @Override
        public Boolean rollbackTrasaction(String _transactionKey) {
            transactionMap = new HashMap<>();
            deletedKey = new HashSet<>();
            transactionKey = "";
            return null;
        }

        @Override
        public void insert(String key, String value) {
            if (transactionKey.isEmpty()) map.put(key, value);
            else transactionMap.put(key, value);
        }

        @Override
        public Boolean delete(String key) {
            if (transactionKey.isEmpty()) map.remove(key);
            else deletedKey.add(key);
            return true;
        }

        @Override
        public String getValue(String key) {
            if (transactionKey.isEmpty()) return map.getOrDefault(key, "");
            return transactionMap.get(key);
        }

        public void printState() {
            for (Map.Entry<String, String> temp : map.entrySet()) {
                if (deletedKey.contains(temp.getKey())) continue;
                if (transactionMap.containsKey(temp.getKey()))
                    System.out.println("Key: " + temp.getKey() + ", Value: " + transactionMap.get(temp.getKey()));
                else
                    System.out.println("Key: " + temp.getKey() + ", Value: " + temp.getValue());
            }
        }
    }

    public static void main(String[] args) {
        MainMap jdbc = new MainMap();
        // Operation
        jdbc.insert("RCB", "RCB"); //
        jdbc.createTrasaction("t1");
        System.out.println(jdbc.getValue("RCB")); // "" = ""
        System.out.println(jdbc.delete("MI")); // true
        jdbc.insert("DC", "Pant"); //
        jdbc.printState(); // {} = {}
        System.out.println("---");
        jdbc.insert("KKR", "Rinku");
        jdbc.insert("DC", "David");
        System.out.println(jdbc.getValue("KKR"));
        jdbc.printState();
        System.out.println("---");
        System.out.println(jdbc.getValue("KKR"));
        System.out.println(jdbc.delete("KKR"));
        System.out.println(jdbc.getValue("KKR"));
        jdbc.insert("KKR", "Russel");
        System.out.println(jdbc.getValue("KKR"));
        System.out.println(jdbc.getValue("RCB")); //  = "RCB"
        System.out.println(jdbc.getValue("DC")); //  = "David"
        System.out.println(jdbc.getValue("GT")); // = ""
        jdbc.commitTrasaction("t1");
        jdbc.insert("RCB", "Virat");
        jdbc.printState();
        System.out.println("---");
        System.out.println(jdbc.getValue("KKR"));
    }

}
