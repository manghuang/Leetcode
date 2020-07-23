package leetcode1;

public class Solution7 {
    public static void main(String[] args) {
        String s1 = "niconiconi";
        String s2 = "nico";
        int a = new Solution7().getMaxRepetitions(s1, 99981, s2, 81);
        System.out.println(a);
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s1.length() == 0 || n1 == 0 || s2 == null || s2.length() == 0 || n2 == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = 0;
        int num1 = 0;
        int num2 = 0;
        boolean isok = true;
        while ((index1 != 0 || index2 != 0) && num1 < n1 || isok) {
            isok = false;
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index2++;
                if (index2 >= s2.length()) {
                    num2++;
                    index2 = 0;
                }
            }
            index1++;
            if (index1 >= s1.length()) {
                num1++;
                index1 = 0;
            }

        }
        //baba baba
        //baab baab
        double a = (double) n1 * num2;
        double b = (double) n2 * num1;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a/b);
        return (int) Math.floor(a / b);

//        int num = 0;
//        int index1 = 0;
//        int index2 = 0;
//        for(int i=0; i< s1.length()*n1; i++){
//            index1 = i%s1.length();
//            if(s1.charAt(index1) == s2.charAt(index2)){
//                index2++;
//                if(index2>=s2.length()){
//                    index2 = 0;
//                    num++;
//                }
//            }
//        }
//
//        return (int)Math.ceil(num / n2);
    }
}
