package newyear.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution0 {

    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parentIds, ArrayList<Integer> costs) {

        if (ids == null || parentIds == null || costs == null) {
            throw new NullPointerException();
        }
        int length = ids.size();
        if (parentIds.size() != length || costs.size() != length) {
            throw new RuntimeException("三组数的个数不等");
        }
        HashMap<Integer, Node> hashMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            int id = ids.get(i);
            int parentId = parentIds.get(i);
            if (hashMap.containsKey(parentId)) {
                Node node = hashMap.get(parentId);
                node.setLeaf(false);
            } else {
                Node node = new Node(parentId, parentId, 0, false);
                hashMap.put(parentId, node);
            }
            if (hashMap.containsKey(id)) {
                Node node = hashMap.get(id);
                node.setParentId(parentId);
                node.setCost(costs.get(i));
            } else {
                Node node = new Node(id, parentId, costs.get(i), true);
                hashMap.put(id, node);
            }
        }
//            for(int i = 0; i < ids.size(); i++) {
//                Node node = new Node();
//                node.setId(ids.get(i));
//                node.setParentId(parentIds.get(i));
//                node.setCost(costs.get(i));
//                node.setLeaf(true);
//                if(hashMap.containsKey(parentIds.get(i))) {
//                    Node pNode = hashMap.get(parentIds.get(i));
//                    pNode.setLeaf(false);
//                }
//                hashMap.put(ids.get(i), node);
//            }
        int ans = 0;
        for (Map.Entry<Integer, Node> nodeEntry :
                hashMap.entrySet()) {
            if (nodeEntry.getValue().isLeaf()) {
                int temp = 0;
                int id = nodeEntry.getKey();
                while (hashMap.get(id).getParentId() != id) {
                    temp += hashMap.get(id).getCost();
                    id = hashMap.get(id).getParentId();
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 待输入list
        ArrayList<Integer> idList = new ArrayList<>();
        ArrayList<Integer> pIdList = new ArrayList<>();
        ArrayList<Integer> costList = new ArrayList<>();

        // 手动构造测试数据
        idList.add(2);
        idList.add(1);
        idList.add(3);
        idList.add(4);

        pIdList.add(1);
        pIdList.add(0);
        pIdList.add(1);
        pIdList.add(0);

        costList.add(3);
        costList.add(2);
        costList.add(2);
        costList.add(3);

        int get = resolve(idList, pIdList, costList);
        System.out.println(get);
    }

    public static class Node {
        private int id;
        private int parentId;
        private int cost;
        private boolean isLeaf;

        public Node() {
        }

        public Node(int id, int parentId, int cost, boolean isLeaf) {
            this.id = id;
            this.parentId = parentId;
            this.cost = cost;
            this.isLeaf = isLeaf;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }
}
