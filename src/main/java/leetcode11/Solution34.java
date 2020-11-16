package leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution34 {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return people;
        }
        int length = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });
//        for (int[] temp: people
//             ) {
//            System.out.println(Arrays.toString(temp));
//        }
//        for (int i = 1; i <length ; i++) {
//            int[] person = people[i];
//            if(person[1] != i){
//                if (i - person[1] >= 0) {
//                    System.arraycopy(people, person[1], people, person[1] + 1, i - person[1]);
//                }
//                people[person[1]] = person;
//            }
//        }
        List<int[]> list  = new ArrayList<>();
        for (int[] person: people
             ) {
            list.add(person[1], person);
        }
        return list.toArray(new int[length][]);
    }
}
