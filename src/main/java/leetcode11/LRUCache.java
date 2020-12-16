package leetcode11;


import java.util.*;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> map;
    /**
     * 按时间排序是关键：是的添加是在队尾添加，删除是在队头删除，更新是找到后放到队尾，使用简单队列
     * 查找操作，使用hashMap映射到队列
     */
//    private final Map<Integer, Long> timezeroMap;
    private final Queue<Integer>  queue;
    private int size;
//    private long timezero;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
//        timezeroMap = new HashMap<>(capacity);
        queue =  new LinkedList<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
//            while(System.currentTimeMillis() == timezero){
//            }
//            timezero = System.currentTimeMillis();
//            timezeroMap.put(key, timezero);
            queue.remove(key);
            queue.offer(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(size < capacity){
//            while(System.currentTimeMillis() == timezero){
//            }
//            timezero = System.currentTimeMillis();
//            timezeroMap.put(key, timezero);
//            System.out.println(key + "  " + timezero);

            if(map.containsKey(key)){
                queue.remove(key);
                queue.offer(key);
                map.put(key, value);
            }else {
                queue.offer(key);
                map.put(key, value);
                size++;
            }
        }else {
            if(map.containsKey(key)){
//                while(System.currentTimeMillis() == timezero){
//                }
//                timezero = System.currentTimeMillis();
//                timezeroMap.put(key, timezero);
                queue.remove(key);
                queue.offer(key);
                map.put(key, value);
            }else {
                // 移除最久未使用的键值对
//                ArrayList<Map.Entry<Integer, Long>> entries = new ArrayList<>(timezeroMap.entrySet());
//                entries.sort(new Comparator<Map.Entry<Integer, Long>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
//                        long l = o1.getValue() - o2.getValue();
//                        if(l < 0){
//                            return -1;
//                        }else if(l == 0){
//                            return 0;
//                        }else {
//                            return 1;
//                        }
//                    }
//                });
//                timezeroMap.remove(entries.get(0).getKey());
//                map.remove(entries.get(0).getKey());
//                while(System.currentTimeMillis() == timezero){
//                }
//                timezero = System.currentTimeMillis();
//                timezeroMap.put(key, timezero);
                int index = queue.poll();
                queue.offer(key);
                map.remove(index);
                map.put(key, value);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        int res  = lruCache.get(2);
        System.out.println(res);
    }
}
