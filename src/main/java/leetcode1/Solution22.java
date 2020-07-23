package leetcode1;

import java.util.LinkedList;

public class Solution22 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        LinkedList<Integer> ll = new LinkedList<>();
        int index = 0;
        // (a,b)  a<-b
        //统计入度
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        //将入度为0的节点放入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                ll.offer(i);
            }
        }

        //遍历，将入度改变的入队
        while (!ll.isEmpty()) {
            int temp = ll.remove();
            result[index++] = temp;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == temp) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        ll.offer(prerequisite[0]);
                    }
                }
            }
        }

        //比较是否还有没有入队的节点，如果有，则说明有环
        if (index < numCourses) {
            return new int[]{};
        }


        return result;
    }

}
