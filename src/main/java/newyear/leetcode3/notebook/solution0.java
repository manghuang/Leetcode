package newyear.leetcode3.notebook;

import java.util.LinkedList;

public class solution0 {
    class MyHashMap {
        private class LinkedNode{
            int key;
            int value;
            LinkedNode next;
            public LinkedNode(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        private LinkedNode[] table;
        /** Initialize your data structure here. */
        public MyHashMap() {
            table = new LinkedNode[8];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if(table[index] == null){
                table[index] = new LinkedNode(key, value);
            }else {
                LinkedNode temp = table[index];
                if(temp.key == key){
                    temp.value = value;
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            temp.next.value = value;
                            return;
                        }
                        temp = temp.next;
                    }
                    temp.next = new LinkedNode(key, value);
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if(table[index] == null){
                return -1;
            }else {
                LinkedNode temp = table[index];
                if(temp.key == key){
                    return temp.value;
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            return temp.next.value;
                        }
                        temp = temp.next;
                    }
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if (table[index] != null){
                LinkedNode temp = table[index];
                if(temp.key == key){
                    table[index] = temp.next;
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            temp.next = temp.next.next;
                            return;
                        }
                        temp = temp.next;
                    }
                }
            }
        }
    }

    class MyHashSet {

        private class LinkedNode{
            int key;
            LinkedNode next;
            public LinkedNode(int key){
                this.key = key;
            }
        }

        private LinkedNode[] table;
        /** Initialize your data structure here. */
        public MyHashSet() {
            table = new LinkedNode[8];
        }

        public void add(int key) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if(table[index] == null){
                table[index] = new LinkedNode(key);
            }else {
                LinkedNode temp = table[index];
                if(temp.key == key){
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            return;
                        }
                        temp = temp.next;
                    }
                    temp.next = new LinkedNode(key);
                }
            }
        }

        public void remove(int key) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if(table[index] == null){
            }else {
                LinkedNode temp = table[index];
                if(temp.key == key){
                    table[index] = temp.next;
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            temp.next = temp.next.next;
                            return;
                        }
                        temp = temp.next;
                    }
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hash = new Integer(key).hashCode();
            hash = hash >>> 16;
            int index = hash % table.length;
            if(table[index] == null){
               return false;
            }else {
                LinkedNode temp = table[index];
                if(temp.key == key){
                    return true;
                }else {
                    while (temp.next != null){
                        if(temp.next.key == key){
                            return true;
                        }
                        temp = temp.next;
                    }
                    return false;
                }
            }
        }
    }
}
