package leetcode1;

public class Solution9 {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int b = new Solution9().numberOfSubarrays(a, 2);
        System.out.println(b);
    }

    //    public int numberOfSubarrays(int @NotNull [] nums, int k) {
//        ArrayList<Integer> al  = new ArrayList<>();
//
//        for (int i = 0; i <nums.length ; i++) {
//            if(nums[i] % 2 ==1){
//               al.add(i);
//            }
//        }
//
//        if(al.size() < k){
//            return 0;
//        }
//
//        int result = 0;
//        int frontIndex = 0;
//        int endIndex = k-1;
//        int a = -1;
//        int b = -1;
//        int c = 0;
//        int d = 0;
//
//        //0 1  3 4
//        while (d <nums.length){
//            a = b;
//            b = al.get(frontIndex++);
//            c = al.get(endIndex++);
//            if(endIndex < al.size()){
//                d = al.get(endIndex);
//            }else{
//                d = nums.length;
//            }
//            result = result + (b-a) * (d-c);
//            System.out.println(a + " " + b + " " + c + " " + d);
//        }
//        return result;
//    }
    public int numberOfSubarrays(int[] nums, int k) {
        int[] temp = new int[nums.length + 2];
        int result = 0;
        int count = 0;
        temp[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                temp[++count] = i;
            }
        }
        temp[++count] = nums.length;
        for (int i = 1; i + k <= count; i++) {
            result += (temp[i] - temp[i - 1]) * (temp[i + k] - temp[i + k - 1]);
        }
        return result;
    }
}
