package leetcode14;

public class Solution3 {

    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return  0;
        }
        int length = prices.length;
        int[] hadBuy = new int[length];
        int[] hadSail = new int[length];
        hadBuy[0] = -prices[0];
        hadSail[0] = 0;
        for(int i=1; i<length; i++){
            hadBuy[i] = Math.max(hadBuy[i-1], hadSail[i-1]-prices[i]);
            hadSail[i] = Math.max(hadSail[i-1], hadBuy[i-1]+prices[i]-fee);
        }
        return hadSail[length-1];
    }
}
