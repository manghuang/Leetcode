package newyear.leetcode1;

import java.util.*;

public class Solution2 {


    /*
        Djstla算法
        Fload算法
        bfs
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //如果目标就是初始，返回0
        if(source == target){
            return 0;
        }
        HashSet<Integer> hasVisitedPoint = new HashSet<>(); // 记录已经访问过的站
        hasVisitedPoint.add(source);

        HashMap<Integer, HashSet<Integer>> routesMap = new HashMap<>(); // routes的hashMap表示，加快搜索速度
        for (int i = 0; i < routes.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                hashSet.add(routes[i][j]);
            }
            routesMap.put(i, hashSet);
        }

        LinkedList<Integer> queue = new LinkedList<>(); // 经过i次换乘后可以到达的站
        queue.offer(source);

        int ans = 0; // 结果，记录换程了几个

        while (!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int point = queue.remove();
                // 以下是在还没有访问过的线路里面看有没有包含当前站的
                Iterator<Integer> iterator = routesMap.keySet().iterator();
                while (iterator.hasNext()){
                    int next = iterator.next();
                    HashSet<Integer> hashSet = routesMap.get(next);
                    // 如果某条线路包含了该站，则遍历，将所有其余站加入hasVisitedPoint和queue
                    if (hashSet.contains(point)) {
                        for (int temp: hashSet
                        ) {
                            // 判断是否有target，有的话就返回
                            if(temp == target){
                                return ans;
                            }
                            if(!hasVisitedPoint.contains(temp)){
                                hasVisitedPoint.add(temp);
                                queue.offer(temp);
                            }
                        }
                        // 移除该线路
                        iterator.remove();
                    }
                }
            }

        }
        // 没用找到target,返回-1
        return -1;
    }
}
