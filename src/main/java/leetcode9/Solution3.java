package leetcode9;

import java.util.*;

public class Solution3 {

    /*
        如果给的数集不重复，递归生成
        如果给的数集中的数有的是重复的，这么破？先统计后排列，交换
     */
    private LinkedList<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        List<List<Integer>> lists = new Solution3().permuteUnique(nums);
        for (List<Integer> list : lists
        ) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo((o1.getValue()));
            }
        });
        for (Map.Entry<Integer, Integer> entry : list
        ) {
            int key = entry.getKey();
            int value = entry.getValue();
            int size = res.size();
            if (size == 0) {
                LinkedList<Integer> list1 = new LinkedList<>();
                for (int i = 0; i < value; i++) {
                    list1.add(key);
                }
                res.offer(list1);
            } else {
                //res中的每一个序列都要加上value个key
                for (int i = 0; i < size; i++) {
                    List<Integer> list1 = res.remove();
                    LinkedList<List<Integer>> temp = new LinkedList<>();
                    temp.offer(list1);//基础序列
                    dps(key, value, temp);//在list1的基础上插入value个key,得到的temp就是结果，再把结果加入res
                    res.addAll(temp);
                }
            }
        }
        return res;
    }

    /**
     * 在temp中的一个序列的基础上插入value个key,结果存储在temp中
     *
     * @param key
     * @param value
     * @param temp
     */
    private void dps(int key, int value, LinkedList<List<Integer>> temp) {
        if (value <= 0) {
            return;
        }
        int size = temp.size();
        // temp里的每一个序列都要加1个key
        for (int i = 0; i < size; i++) {
            List<Integer> list = temp.remove();
            int index = list.lastIndexOf(key);
            // 在list的基础上插入1个key
            for (int j = index + 1; j <= list.size(); j++) {
                LinkedList<Integer> list1 = new LinkedList<>(list);
                list1.add(j, key);
                temp.add(list1);
            }
        }
        dps(key, value - 1, temp);
    }

}
