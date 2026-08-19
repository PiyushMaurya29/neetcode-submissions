// class Twitter {
//     class Tweet{
//         Tweet next;
//         int tweetTime;
//         int tweetId;
//         Tweet(int tweetTime, int tweetId){
//             this.tweetTime = tweetTime;
//             this.tweetId = tweetId;
//         }
//     }

//     Map<Integer, Set<Integer>> userFollowersMap;
//     Map<Integer, Tweet> userTweetMap;
//     int tweetTime;
//     public Twitter() {
//         userFollowersMap = new HashMap<>();
//         userTweetMap = new HashMap<>();
//         tweetTime = 0;
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         tweetTime++;
//         Tweet newTweet = new Tweet(tweetTime, tweetId);
//         if(userTweetMap.containsKey(userId)){
//             newTweet.next = userTweetMap.get(userId);
//             userTweetMap.put(userId, newTweet);
//         }
//         else{
//             userTweetMap.put(userId, newTweet);
//         }
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.tweetTime, a.tweetTime));

//         if(userTweetMap.containsKey(userId)){
//             maxHeap.offer(userTweetMap.get(userId));
//         }
//         if(userFollowersMap.containsKey(userId)){
//             for(int f : userFollowersMap.get(userId)){
//                 if(userTweetMap.containsKey(f)){
//                     maxHeap.offer(userTweetMap.get(f));
//                 }
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         while(result.size()<10 && !maxHeap.isEmpty()){
//             Tweet currTweet = maxHeap.poll();
//             result.add(currTweet.tweetId);
//             if(currTweet.next != null){
//                 maxHeap.offer(currTweet.next);
//             }
//         }
//         return result;
//     }
    
//     public void follow(int followerId, int followeeId) {
//         if(!userFollowersMap.containsKey(followerId)){
//             userFollowersMap.put(followerId, new HashSet<>());
//         }
//         userFollowersMap.get(followerId).add(followeeId);
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//         if(userFollowersMap.containsKey(followerId)){
//             userFollowersMap.get(followerId).remove(followeeId);
//         }
//     }
// }





class Twitter {
    Map<Integer, Set<Integer>> userFollowersMap;
    Map<Integer, List<int[]>> userTweetMap;
    int tweetTime;
    public Twitter() {
        userFollowersMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        tweetTime = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetTime++;
        if(!userTweetMap.containsKey(userId)){
            userTweetMap.put(userId, new ArrayList<>());
        }
        userTweetMap.get(userId).add(new int[]{tweetTime, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> list = new ArrayList<>();
        if(userTweetMap.containsKey(userId)){
            for(int[] p : userTweetMap.get(userId)){
                list.add(p);
            }
        }
        if(userFollowersMap.containsKey(userId)){
            for(int f : userFollowersMap.get(userId)){
                // if(userTweetMap.containsKey(f)){
                //     for(int[] p : userTweetMap.get(f)){
                //         list.add(p);
                //     }
                // }
                List<int[]> tweetList = userTweetMap.get(f);
                if(tweetList != null){
                    list.addAll(tweetList);
                }
            }
        }
        Collections.sort(list, (a,b) -> Integer.compare(b[0], a[0]));

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<Math.min(10, list.size()) ; i++){
            result.add(list.get(i)[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userFollowersMap.containsKey(followerId)){
            userFollowersMap.put(followerId, new HashSet<>());
        }
        userFollowersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // userFollowersMap.get(followerId).remove(followeeId);
        if(userFollowersMap.containsKey(followerId)){
            userFollowersMap.get(followerId).remove(followeeId);
        }
    }
}
