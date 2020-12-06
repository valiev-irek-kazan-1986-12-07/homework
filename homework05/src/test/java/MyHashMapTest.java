import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void get() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        HashMap<Integer, String> hashMap = new HashMap<>();
        myHashMap.put(1, "First");
        hashMap.put(1, "First");
        myHashMap.put(2, "Second");
        hashMap.put(2, "Second");
        assertEquals(hashMap.get(1), myHashMap.get(1));
        assertEquals(hashMap.get(2), myHashMap.get(2));
    }

    @Test
    void size() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        HashMap<Integer, String> hashMap = new HashMap<>();
        assertEquals(hashMap.size(), myHashMap.size());
        myHashMap.put(1, "First");
        hashMap.put(1, "One");
        myHashMap.put(2, "Second");
        hashMap.put(2, "Two");
        assertEquals(hashMap.size(), myHashMap.size());
    }

    @Test
    void containsKey() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        myHashMap.put(1, "First");
        hashMap.put(1, "One");
        assertEquals(hashMap.containsKey(1), myHashMap.containsKey(1));
        MyHashMap<String, String> myHashMap1 = new MyHashMap<>();
        HashMap<String, String> hashMap1 = new HashMap<>();
        myHashMap1.put("Odin", "Nido");
        hashMap1.put("Odin", "One");
        assertEquals(hashMap1.containsKey("Odin"), myHashMap1.containsKey("Odin"));
    }

    @Test
    void put() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        myHashMap.put(1, "One");
        hashMap.put(1, "One");
        assertEquals(hashMap.put(1, "One"), myHashMap.put(1, "One"));
    }


    @Test
    void remove() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        HashMap<Integer, String> hashMap = new HashMap<>();
        myHashMap.put(1, "First");
        hashMap.put(1, "First");
        myHashMap.put(2, "Second");
        hashMap.put(2, "Second");
        myHashMap.remove(1);
        hashMap.remove(1);
        assertEquals(hashMap.containsKey(1), myHashMap.containsKey(1));
        assertEquals(hashMap.remove(2), myHashMap.remove(2));
    }

    @Test
    void keySet() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        Set<Integer> set = new LinkedHashSet<>();
        myHashMap.put(1, "First");
        myHashMap.put(2, "Second");
        myHashMap.put(3, "Third");
        myHashMap.put(4, "Fourth");
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        assertEquals(set, myHashMap.keySet());
    }

    @Test
    void values() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        List<String> list = new ArrayList<>();
        myHashMap.put(1, "First");
        myHashMap.put(2, "Second");
        myHashMap.put(3, "Third");
        myHashMap.put(4, "Fourth");
        list.add(0, "First");
        list.add(1, "Second");
        list.add(2, "Third");
        list.add(3, "Fourth");
        assertEquals(list, myHashMap.values());
    }

    @Test
    void entrySet() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        Map<Integer, String> map = new HashMap<>();
        myHashMap.put(1, "First");
        myHashMap.put(2, "Second");
        myHashMap.put(3, "Third");
        myHashMap.put(4, "Fourth");
        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");
        map.put(4, "Fourth");
        assertEquals(map.entrySet(), myHashMap.entrySet());
    }
}