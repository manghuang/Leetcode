package leetcode15;

import java.util.*;

public class Solution7 {

    // 同一个人多个账号的名字相同
    // 相同账户名字的不一定是同一个人
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, UnionFind> map = new HashMap<>();
        for (List<String> account: accounts
             ) {
            if(map.containsKey(account.get(0))){
                UnionFind unionFind = map.get(account.get(0));
                for (int i = 1; i < account.size(); i++) {
                    unionFind.union(account.get(1), account.get(i));
                }
            }else {
                UnionFind unionFind = new UnionFind();
                for (int i = 1; i < account.size(); i++) {
                    unionFind.union(account.get(1), account.get(i));
                }
                map.put(account.get(0), unionFind);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String name: map.keySet()
             ) {

            // parent -> 有序集合
            Map<String, PriorityQueue<String>> queueMap = new HashMap<>();

            // child -> parent
            UnionFind unionFind = map.get(name);

            for (String child: unionFind.getParent().keySet()
                 ) {
                String parent = unionFind.find(child);
                if(queueMap.containsKey(parent)){
                    queueMap.get(parent).add(child);
                }else {
                    PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    });
                    priorityQueue.add(child);
                    queueMap.put(parent, priorityQueue);
                }
            }
            for (String parent: queueMap.keySet()
                 ) {
                List<String> list1 = new ArrayList<>();
                list1.add(name);
                PriorityQueue<String> priorityQueue = queueMap.get(parent);
                while (!priorityQueue.isEmpty()){
                    list1.add(priorityQueue.poll());
                }
                ans.add(list1);
            }
        }
        return ans;
    }

    private  static class UnionFind{
        private final Map<String, String> parent;

        private int count;

        public UnionFind(){
            parent = new HashMap<>();
            count = 0;
        }

        public Map<String, String> getParent(){
            return parent;
        }
        public String find(String mail){
            if(!parent.containsKey(mail)){
                parent.put(mail, mail);
                count++;
            }
            if(!Objects.equals(parent.get(mail), mail)){
                parent.put(mail, find(parent.get(mail)));
            }
            return parent.get(mail);
        }

        public void union(String mail1, String mail2){
            String mail1Par = find(mail1);
            String mail2Par = find(mail2);

            if(!Objects.equals(mail1Par, mail2Par)){
                parent.put(mail1Par, mail2Par);
                count--;
            }
        }
    }
}
