package com.lirenxing.test;


import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestCollection {

    @Test
    public void demo1(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1520);
        map.put(2,222);
        map.put(3,2323);
        map.put(4,13);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            Integer key = next.getKey();
            System.out.println(key+"===>"+value);
        }
    }


}
