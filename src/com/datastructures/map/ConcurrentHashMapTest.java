package com.datastructures.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
 public class ConcurrentHashMapTest {

      public static void main(String[] args) {

            // ConcurrentHashMap implementation details
            Map<String, String> concurrentHMap = new ConcurrentHashMap<String, String>();
            concurrentHMap.put("FIRST", "1");
            concurrentHMap.put("SECOND", "2");
            concurrentHMap.put("THIRD", "3");
            concurrentHMap.put("FOURTH", "4");
            concurrentHMap.put("FIFTH", "5");
            concurrentHMap.put("SIXTH", "6");
            System.out.println("ConcurrentHashMap before iteration : " + concurrentHMap);
            Iterator<String> ccHMapIterator = concurrentHMap.keySet().iterator();

            while (ccHMapIterator.hasNext()) {
                  String key = ccHMapIterator.next();
                  if (key.equals("FOURTH"))
                        concurrentHMap.put(key + "-GAURAV", "I AM NEW KEY IN CCHMAP");
            }
            System.out.println("ConcurrentHashMap after iteration : " + concurrentHMap);

            System.out.println("**************************************");
            // HashMap implementation details
            Map<String, String> hMap = new HashMap<String, String>();
            hMap.put("FIRST", "1");
            hMap.put("SECOND", "2");
            hMap.put("THIRD", "3");
            hMap.put("FOURTH", "4");
            hMap.put("FIFTH", "5");
            hMap.put("SIXTH", "6");
            System.out.println("HashMap before iteration : " + hMap);
            Iterator<String> hashMapIterator = hMap.keySet().iterator();

            while (hashMapIterator.hasNext()) {
                  String key = hashMapIterator.next();
                  if (key.equals("FOURTH"))
                        hMap.put(key + "-SHIVAM", "I AM NEW KEY IN HMAP");
            }
            System.out.println("HashMap after iteration : " + hMap);
      }
}
