package leetcode3;

public class Solution8 {
    public static void main(String[] args) {
        int a = 506;
        int res = new Solution8().translateNum(a);
        System.out.println(res);
    }

    //    private int res;
//    public int translateNum(int num) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (num != 0){
//            int a = num%10;
//            num = num/10;
//            arrayList.add(a);
//        }
//        Collections.reverse(arrayList);
////        System.out.println(arrayList);
//        dps(arrayList, 0, arrayList.size());
//        return res;
//    }
//
//    private void dps(ArrayList<Integer> arrayList, int index, int length) {
//        if(index >= length){
//            if(index == length) {
//                this.res++;
//            }
//            return;
//        }
//        dps(arrayList, index+1, length);
//        int temp = arrayList.get(index);
//        if(temp == 1){
//            dps(arrayList,index+2,length);
//        }else if(temp == 2) {
//            if(index+1 < length && arrayList.get(index+1)<=5 ){
//                dps(arrayList,index+2,length);
//            }
//        }
//    }
    public int translateNum(int num) {
        String str = String.valueOf(num);
        System.out.println(str);
        return 0;
    }
}
