package leetcode14;

import java.util.HashMap;

/*
    双向链表+哈希表
    双向链表存储先后顺序
    哈希表key为页码，value为双向链表此页在双向链表中的地址
 */
public class LRUCache {

    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){

        }

        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private DLinkedNode head, tail;
    private HashMap<Integer, DLinkedNode> hashMap;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    // 查询
    public int get(int key) {
        /*
            如果存在哈希表中：
                取对应的value，得到node的地址，将node移到head后面，返回node的值
            如果不存在哈希表中：
                返回-1；
         */
        if(hashMap.containsKey(key)){
            DLinkedNode node = hashMap.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            return node.value;
        }else {
            return -1;
        }
    }

    // 添加，达到上限要删除
    public void put(int key, int value) {
        /*
            如果存在哈希表中：
                返回?更新
            如果不存在哈希表中；
                判断是不是达到上限，如果是：
                    删除tail前面的node
                    删除哈希表中对应的key？
                    在head后面添加新node，值为value
                    在哈希表中，添加key,node的地址
                如果不是：
                    cap--;
                    在head后面添加新node，值为value
                    在哈希表中，添加key,node的地址
         */
        if(hashMap.containsKey(key)){
            DLinkedNode node = hashMap.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            return;
        }
        if(capacity == 0){
            DLinkedNode lastNode = tail.pre;
            lastNode.pre.next = tail;
            tail.pre = lastNode.pre;
            hashMap.remove(lastNode.key);
            DLinkedNode node = new DLinkedNode(key, value);
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            hashMap.put(key, node);
        }else {
            capacity--;
            DLinkedNode node = new DLinkedNode(key, value);
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            hashMap.put(key, node);
        }
    }
}
