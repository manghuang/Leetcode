package leetcode7;

import java.util.List;

public class Solution7 {

    /*
        方法一：dps
        方法二：bps
     */
    private boolean[] isVisteds;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        int length = rooms.size();
        this.isVisteds = new boolean[length];
        isVisteds[0] = true;
        dps(rooms, 0);
        for (boolean isVisted : isVisteds) {
            if (!isVisted) {
                return false;
            }
        }
        return true;
    }

    private void dps(List<List<Integer>> rooms, int roomNum) {
        List<Integer> room = rooms.get(roomNum);
        if (room == null || room.size() == 0) {
            return;
        }
        for (int tempNum : room) {
            if (!isVisteds[tempNum]) {
                isVisteds[tempNum] = true;
                dps(rooms, tempNum);
            }
        }
    }
}
