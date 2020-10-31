package leetcode11;

import java.util.*;

public class Solution14 {

    HashMap <Integer, Set<Integer>> hashMap;
    List<Integer> list;
    /** Initialize your data structure here. */
    public Solution14() {
        this.hashMap = new HashMap<>();
        list = new ArrayList<>();
    }
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        // System.out.println("insert" + val + "  " + list);
        if(hashMap.containsKey(val)){
            Set<Integer> set = hashMap.get(val);
            if(set.isEmpty()){
                set.add(list.size()-1);
                return true;
            }else {
                set.add(list.size()-1);
                return false;
            }
        }else {
            Set<Integer> set = new HashSet<>();
            set.add(list.size()-1);
            hashMap.put(val, set);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(hashMap.containsKey(val)){
            Set<Integer> set = hashMap.get(val);
            if(set.isEmpty()){
                //   System.out.println("remoce111" + val + "  " + list);
                return false;
            }else {
                int index = set.iterator().next();
                int lastIndex = list.size() - 1;
                int lastVal = list.get(lastIndex);
                list.set(index,lastVal);
                list.remove(lastIndex);
                set.remove(index);
                Set<Integer> temp = hashMap.get(lastVal);
                temp.add(index);
                temp.remove(lastIndex);
                //   System.out.println("remoce" + val + "  " + list);
                return true;
            }
        }else {
            //   System.out.println("remoce" + val + "  " + list);
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // System.out.println("getRandom"   + list);
        return list.get((int)(Math.random() * list.size()));
    }
}
