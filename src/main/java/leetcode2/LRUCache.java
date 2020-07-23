package leetcode2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

//    private final HashMap<Integer, Integer> hashMap;
//    private final int capacity;
//    //辅助记录使用时间先后的数据结构
//    private final LinkedList<Integer> linkedList;
//
//    public LRUCache(int capacity) {
//        this.hashMap = new HashMap<>(capacity);
//        this.capacity = capacity;
//        this.linkedList = new LinkedList<>();
//    }
//
//
//    public int get(int key) {
//        if(hashMap.containsKey(key)){
//            //更新辅助数据结构
//            linkedList.remove((Integer) key);
//            linkedList.offer(key);
//
//            return hashMap.get(key);
//        }else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//
//        if(hashMap.containsKey(key)){
//            ////更新辅助数据结构
//            linkedList.remove((Integer)key);
//            linkedList.offer(key);
//           hashMap.put(key, value);
//        }else{
//            if(hashMap.size()>= this.capacity){
//              hashMap.remove(linkedList.remove());
//            }
//            //更新辅助数据结构
//            linkedList.offer(key);
//            hashMap.put(key, value);
//        }
//    }

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));   // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4


    }

    public int get(int key) {
        return super.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
