package leetcode16;

import java.util.HashMap;

public class LRU {

    public static class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode(){}

        public DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, DLinkNode> hashMap;
    private DLinkNode head, tail;

    public LRU(int capacity){
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre  = head;
    }

    public int get(int key){
        if(!hashMap.containsKey(key)){
            return 0;
        }else {
            DLinkNode node = hashMap.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            return node.value;
        }
    }

    public void put(int key, int value){
        if(hashMap.containsKey(key)){
            // 更新
            DLinkNode node = hashMap.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.pre = head;
            head.next = node;
        }else{
            if(this.capacity == 0){
                // 替换
                DLinkNode remNode = tail.pre;
                hashMap.remove(remNode.key);
                remNode.pre.next = tail;
                tail.pre = remNode.pre;
                remNode = null;

                DLinkNode node = new DLinkNode(key, value);
                hashMap.put(key, node);
                node.next = head.next;
                node.pre = head;
                head.next = node;
            }else{
                // 直接添加
                DLinkNode node = new DLinkNode(key, value);
                hashMap.put(key, node);
                capacity--;
                node.next = head.next;
                node.pre = head;
                head.next = node;
            }
        }
    }
}
