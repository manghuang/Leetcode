package leetcode1;

import java.util.*;

class Twitter {

    Map<Integer, Set<Integer>> userIdToUserId;
    Map<Integer, Set<Inner>> userIdToTweetId;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.userIdToUserId = new HashMap<>();
        this.userIdToTweetId = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userIdToTweetId.containsKey(userId)) {
            userIdToTweetId.put(userId, new HashSet<Inner>());
        }
        Set<Inner> hs = userIdToTweetId.get(userId);

        hs.add(new Inner(tweetId, System.nanoTime()));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Inner> tw = new ArrayList<>();

        Set<Inner> self = userIdToTweetId.get(userId);
        if (self != null) {
            tw.addAll(self);
        }

        Set<Integer> hs = userIdToUserId.get(userId);
        if (hs != null) {
            for (Integer id : hs) {
                Set<Inner> others = userIdToTweetId.get(id);
                if (others != null) {
                    tw.addAll(others);
                }
            }
        }

        Collections.sort(tw);
        tw = tw.subList(0, tw.size() > 10 ? 10 : tw.size());
        List<Integer> result = new ArrayList<>();

        if (tw != null) {
            for (Inner inner : tw) {
                result.add(inner.getTweetId());
            }
        }

        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userIdToUserId.containsKey(followerId)) {
            userIdToUserId.put(followerId, new HashSet<Integer>());

        }
        if (followeeId != followerId) {
            Set<Integer> hs = userIdToUserId.get(followerId);
            hs.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userIdToUserId.containsKey(followerId)) {
            return;
        }
        Set<Integer> hs = userIdToUserId.get(followerId);
        if (hs != null && hs.contains(followeeId)) {
            hs.remove(followeeId);
        }
    }

    class Inner implements Comparable {
        private int tweetId;
        private long time;

        public Inner(int tweetId, long time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        public long getTime() {
            return time;
        }

        public int getTweetId() {
            return tweetId;
        }

        @Override
        public int compareTo(Object o) {
            Inner inner = (Inner) o;
            return -(int) (this.time - (inner.getTime()));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return tweetId == inner.tweetId &&
                    time == inner.time;
        }

    }

//    public static void main(String[] args) {
//      Twitter obj = new Twitter();
//      obj.postTweet(1,5);
//      obj.follow(1,1);
//      List<Integer> param_2 = obj.getNewsFeed(1);
//      System.out.println(param_2);
//
//    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */