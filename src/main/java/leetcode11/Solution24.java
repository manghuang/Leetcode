package leetcode11;

public class Solution24 {


    /*
        方法一、dfs+枚举所有情况
        方法二、dfs+记忆化数组
        方法三、动态规划
     */
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length < 2){
//            return 0;
//        }
//        int length = prices.length;
//        //从第i天开始到结束，下一步需要购买所能获得的最大利润
//        int[] needBuy = new int[length];
//        //从第i天开始到结束，下一步需要卖出所能获得的最大利润
//        int[] needSell = new int[length];
//        for (int i = length-1; i >= 0; i--) {
//            if(i == length-1){
//                needBuy[i] = 0;
//                needSell[i] = prices[i];
//                continue;
//            }
//            needBuy[i] = Math.max(-prices[i] + needSell[i+1], needBuy[i+1]);
//            needSell[i] = Math.max(prices[i] + needBuy[i+1], needSell[i+1]);
//        }
//        return needBuy[0];
//    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int length = prices.length;
       int needBuy = 0;
       int needSell = 0;
        for (int i = length-1; i >= 0; i--) {
            if(i == length-1){
                needBuy = 0;
                needSell = prices[i];
                continue;
            }
            int tempBuy = Math.max(-prices[i] + needSell, needBuy);
            int tempSell = Math.max(prices[i] + needBuy, needSell);
            needBuy = tempBuy;
            needSell = tempSell;
        }
        return needBuy;
    }

    public static void main(String[] args) {
        int res = new Solution24().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }
}
