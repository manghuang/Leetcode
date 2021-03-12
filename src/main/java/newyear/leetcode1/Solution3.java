package newyear.leetcode1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {


    /*
        dp
        模拟
     */
//    private int ans = 0;
//    public int numOfWays(int n) {
//        if(n == 0){
//            return 0;
//        }
//        int[][] grid = new int[n][3];
//        dfs(grid, 0, 0);
//        return ans;
//    }

//    private void dfs(int[][] grid, int x, int y) {
//        if(x >= grid.length || y >= 3){
//            ans++;
//            return;
//        }
//        if(x == 0){
//            if(y == 0){
//                for (int i = 0; i < 3; i++) {
//                    grid[x][y] = i;
//                    dfs(grid, x, y+1);
//                }
//            }else {
//                for (int i = 0; i < 3; i++) {
//                    if(grid[x][y-1] == i){
//                        continue;
//                    }
//                    grid[x][y] = i;
//                    if (y == 1){
//                        dfs(grid, x, y+1);
//                    }else {
//                        dfs(grid, x+1, 0);
//                    }
//                }
//            }
//        }else {
//            if(y == 0){
//                for (int i = 0; i < 3; i++) {
//                    if(grid[x-1][y] == i){
//                        continue;
//                    }
//                    grid[x][y] = i;
//                    dfs(grid, x, y+1);
//                }
//            }else {
//                for (int i = 0; i < 3; i++) {
//                    if(grid[x-1][y] == i || grid[x][y-1] == i){
//                        continue;
//                    }
//                    grid[x][y] = i;
//                    if (y == 1){
//                        dfs(grid, x, y+1);
//                    }else {
//                        dfs(grid, x+1, 0);
//                    }
//                }
//            }
//        }
//    }

    private static final int mod = (int) (Math.pow(10, 9) + 7);
    public int numOfWays(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 12;
        }
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j){
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if(j == k){
                        continue;
                    }
                    HashSet<Integer> hashSet = getAll(i, j, k);
                    hashMap.put(100*i+10*j+k, hashSet);
                }
            }
        }
//        return dfs(0,hashMap.keySet(), hashMap, n);
        HashMap<Integer, Integer> nNum = new HashMap<>();
        for (int key: hashMap.keySet()
             ) {
            nNum.put(key, 1);
        }
        for (int i = 1; i < n ; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (int key: hashMap.keySet()
                 ) {
                HashSet<Integer> hashSet = hashMap.get(key);
                long aa  = 0;
                for (int nextKey: hashSet
                     ) {
                    aa += nNum.get(nextKey) % mod;
                }
                aa = aa % mod;
                temp.put(key, Math.toIntExact(aa));
            }
            nNum = temp;
        }
        long ans = 0;
        for (int key: nNum.keySet()
             ) {
            ans += nNum.get(key) % mod;
        }
        ans = ans % mod;
        return Math.toIntExact(ans);
    }

//    private int dfs(int index, Set<Integer> keySet, HashMap<Integer, HashSet<Integer>> hashMap, int n) {
//        if(index >= n){
//            return 1;
//        }
//        int ans = 0;
//        for (int num : keySet
//             ) {
//            ans += dfs(index+1, hashMap.get(num), hashMap, n);
//        }
//        return ans % mod;
//    }


    private HashSet<Integer> getAll(int one, int two, int three) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if(i == one){
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if(i == j || two == j){
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if(j == k || three == k){
                        continue;
                    }
                    hashSet.add(i*100+j*10+k);
                }
            }
        }
        return hashSet;
    }

    public static void main(String[] args) {
        int ans = new Solution3().numOfWays(5000);
        System.out.println(ans);

    }

}
