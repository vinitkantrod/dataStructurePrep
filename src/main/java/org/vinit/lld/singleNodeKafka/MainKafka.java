package org.vinit.lld.singleNodeKafka;

import org.vinit.lld.singleNodeKafka.serdes.Deserializer;
import org.vinit.lld.singleNodeKafka.serdes.JsonPOJODeserializer;
import org.vinit.lld.singleNodeKafka.serdes.JsonPOJOSerializer;
import org.vinit.lld.singleNodeKafka.serdes.Serializer;

import java.util.*;

public class MainKafka {

    // POJO classes
    static public class PageView {
        public String user;
        public String page;
        public Long timestamp;
        public PageView(String u, String p) {
            this.page = p;
            this.user = u;
            this.timestamp = System.currentTimeMillis();
        }
        public PageView(String u, String p, Long timestamp) {
            this.page = p;
            this.user = u;
            this.timestamp = timestamp;
        }
        public PageView() {}
        public String toString() {
            return this.user + " and page " + this.page + " at time: " + this.timestamp;
        }
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

        // Serializer Example
        Serializer<PageView> pageViewSerializer = new JsonPOJOSerializer<>();
        props.put("JsonPOJOClass", PageView.class);
        pageViewSerializer.configure(props, false);
        PageView pv = new PageView("Vinit", "1");
        byte[] bytes = pageViewSerializer.serialize("PageView", pv);

        // Deserializer Example
        Deserializer<PageView> pageViewDeserializer = new JsonPOJODeserializer<>();
        pageViewDeserializer.configure(props, false);
        PageView p = pageViewDeserializer.deserialize("PageView", bytes);
        System.out.println(p.toString());
    }
}
