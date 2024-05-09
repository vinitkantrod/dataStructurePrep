package org.vinit.lld.singleNodeKafka;

import org.vinit.lld.singleNodeKafka.serdes.JsonPOJOSerializer;
import org.vinit.lld.singleNodeKafka.serdes.Serializer;

import java.util.*;

public class MainKafka {

    // POJO classes
    static public class PageView {
        public String user;
        public String page;
        public Long timestamp;
    }
    public static void main(String[] args) throws Exception{
//        Properties props = new Properties();
//        Properties sysProps = System.getProperties();
//        Set set = sysProps.entrySet();
//        Iterator itr = set.iterator();
//        while (itr.hasNext()) {
//            Map.Entry entry = (Map.Entry) itr.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        Map<String, Object> props = new HashMap<>();
        Serializer<PageView> pageViewSerializer = new JsonPOJOSerializer<>();
        props.put("JsonPOJOClass", PageView.class);
        pageViewSerializer.configure(props, false);
    }
}
