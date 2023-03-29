package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2023/3/29
 * 设计推特
 */
public class L355 {

    private static class Twitter {

        private Map<Integer, User> users;

        private static long id = 0;

        public Twitter() {
            users = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user;
            if (users.containsKey(userId)) {
                user = users.get(userId);
            } else {
                user = new User(userId);
                users.put(userId, user);
            }
            long timestamp = id++;
            Data data = new Data(userId, tweetId, timestamp);
            user.myLists.add(data);
            user.allLists.add(data);
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                if (entry.getValue().followSet.contains(userId)) {
                    entry.getValue().allLists.offer(data);
                }
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> newsFeed = new ArrayList<>();
            if (users.containsKey(userId)) {
                LinkedList<Data> allLists = users.get(userId).allLists;
                for (int i = allLists.size() - 1; i >= 0 && newsFeed.size() < 10; i--) {
                    newsFeed.add(allLists.get(i).tweetId);
                }
            } else { // 用户不存在，进行保存
                users.put(userId, new User(userId));
            }
            return newsFeed;
        }

        public void follow(int userId, int followUserId) {
            User user, followUser;
            if (users.containsKey(userId) && users.containsKey(followUserId)) { // users中两个用户都存在
                user = users.get(userId);
                followUser = users.get(followUserId);
                if (!user.followSet.contains(followUserId)) {
                    user.followSet.add(followUserId);
                    LinkedList<Data> followUserLists = followUser.myLists;
                    if (user.allLists.size() == 0 || followUserLists.getLast().timestamp <= user.allLists.getFirst().timestamp) {
                        user.allLists.addAll(0, followUserLists);
                    } else if (followUserLists.getFirst().timestamp >= user.allLists.getLast().timestamp) {
                        user.allLists.addAll(followUserLists);
                    } else {
                        Iterator<Data> followUserIterator = followUserLists.iterator();
                        Data followUserNextData = null;
                        for (int i = 0; i < user.allLists.size() && (followUserIterator.hasNext() || followUserNextData != null); i++) {
                            if (followUserNextData == null) {
                                followUserNextData = followUserIterator.next();
                            }
                            if (user.allLists.get(i).timestamp > followUserNextData.timestamp) {
                                user.allLists.add(i, followUserNextData);
                                followUserNextData = null;
                            }
                        }
                        if (followUserNextData != null) {
                            user.allLists.add(followUserNextData);
                        }
                        while (followUserIterator.hasNext()) {
                            user.allLists.add(followUserIterator.next());
                        }
                    }
                }
                return;
            }
            if (users.containsKey(userId)) { // users中仅存在userId
                followUser = new User(followUserId);
                users.put(followUserId, followUser);
                users.get(userId).followSet.add(followUserId);
                return;
            }
            if (users.containsKey(followUserId)) { // users中仅存在followUserId
                followUser = users.get(followUserId);
                user = new User(userId);
                users.put(userId, user);
                user.followSet.add(followUserId);
                user.allLists.addAll(followUser.myLists);
                return;
            }
            // 两个用户都不存在
            user = new User(userId);
            followUser = new User(followUserId);
            user.followSet.add(followUserId);
            users.put(userId, user);
            users.put(followUserId, followUser);
        }

        public void unfollow(int userId, int followUserId) {
            if (users.containsKey(userId) && users.containsKey(followUserId)) { // 两个用户都存在
                User user = users.get(userId);
                if (user.followSet.contains(followUserId)) {
                    user.followSet.remove(followUserId);
                    LinkedList<Data> unfollowUserLists = users.get(followUserId).myLists;
                    for (Data unfollowData : unfollowUserLists) {
                        user.allLists.remove(unfollowData);
                    }
                }
                return;
            }
            // 将不存在users中的用户，进行保存
            if (!users.containsKey(userId)) {
                User user = new User(userId);
                users.put(userId, user);
            }
            if (!users.containsKey(followUserId)) {
                User followUser = new User(followUserId);
                users.put(followUserId, followUser);
            }
        }

        static class Data {
            public int userId;
            public int tweetId;

            public long timestamp;

            public Data(int userId, int tweetId, long timestamp) {
                this.userId = userId;
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }
        }

        static class User {
            public int userId;

            public Set<Integer> followSet = new HashSet<>();

            public LinkedList<Data> myLists = new LinkedList<>();

            public LinkedList<Data> allLists = new LinkedList<>();

            public User(int userId) {
                this.userId = userId;
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 6765);
        twitter.postTweet(5, 671);
        twitter.postTweet(3, 2868);
        twitter.postTweet(4, 8148);
        twitter.postTweet(4, 386);
        twitter.postTweet(3, 6673);
        twitter.postTweet(3, 7946);
        twitter.postTweet(3, 1445);
        twitter.postTweet(4, 4822);
        twitter.postTweet(1, 3781);
        twitter.postTweet(4, 9038);
        twitter.postTweet(1, 9643);
        twitter.postTweet(3, 5917);
        twitter.postTweet(2, 8847);
        twitter.follow(1, 3);
        twitter.follow(1, 4);
        twitter.follow(4, 2);
        twitter.follow(4, 1);
        twitter.follow(3, 2);
        twitter.follow(3, 5);
        twitter.follow(3, 1);
        twitter.follow(2, 3);
        twitter.follow(2, 1);
        twitter.follow(2, 5);
        twitter.follow(5, 1);
        twitter.follow(5, 2);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        System.out.println(twitter.getNewsFeed(3));
        System.out.println(twitter.getNewsFeed(4));
        System.out.println(twitter.getNewsFeed(5));
    }
}
