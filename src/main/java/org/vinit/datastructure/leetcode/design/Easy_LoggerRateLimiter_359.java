package org.vinit.datastructure.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class Easy_LoggerRateLimiter_359 {

    class Logger {

        Map<String, Integer> logMap = new HashMap<>();
        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!logMap.containsKey(message)) {
                logMap.put(message, timestamp);
                return true;
            }
            if (timestamp - logMap.get(message) >= 10) {
                logMap.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
