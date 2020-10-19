package leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                if(dps(i, j)){
                    String str =  j + "/" + i;
                    res.add(str);
                }
            }
        }
        return res;
    }

    private boolean dps(int i, int j) {
        if(j == 1){
            return true;
        }
        if(i % j == 0){
            return false;
        }else {
            return dps(j, i%j);
        }

    }
}
