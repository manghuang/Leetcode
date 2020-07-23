package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {
    /*
        先找出最大的糖果数，然后枚举每一个孩子，当它的糖果书加上额为的糖果数后，与最大值比较
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum = 0;
        for (int candie :
                candies) {
            maxNum = Math.max(maxNum, candie);
        }
        ArrayList<Boolean> res = new ArrayList<>();
        for (int candie :
                candies) {
            res.add((candie + extraCandies) >= maxNum);
        }
        return res;
    }
}
