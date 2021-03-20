package newyear.leetcode3.notebook;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            ArrayList<Integer> ans = solve(m, n);
            if(ans.size() == 0){
                System.out.println("no");
            }else {
                for (Integer an : ans) {
                    System.out.print(an + " ");
                }
                System.out.println();
            }
        }
    }

    private static ArrayList<Integer> solve(int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = m; i <= n ; i++) {
            if(isOk(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean isOk(int num) {
        int temp = 0;
        int b = num;
        while (b != 0){
            int a = b % 10;
            b = b / 10;
            temp += (int) Math.pow(a, 3);
        }
        return temp == num;
    }

}



//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            double ans = solve(n, m);
//            System.out.printf("%.2f\n", ans);
//        }
//    }
//
//    private static double solve(int n, int m) {
//        double ans = n;
//        double temp = n;
//        for (int i = 1; i < m; i++) {
//            temp = Math.sqrt(temp);
//            ans += temp;
//        }
//        return ans;
//    }
//}
