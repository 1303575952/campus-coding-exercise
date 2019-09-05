package map.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU的实现，用LinkedHashMap
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache1() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache1<Integer, String> cache = new LRUCache1<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}

