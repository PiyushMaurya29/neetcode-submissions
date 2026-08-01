class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> set = new HashSet<>();
        for(var d : deadends){
            set.add(d);
        }
        if(set.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        Set<String> visitedSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visitedSet.add("0000");

        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0 ; i<levelSize ; i++){
                String curr = queue.poll();
                if(curr.equals(target)){
                    return level;
                }

                char[] arr = curr.toCharArray();
                for(int j=0 ; j<4 ; j++){
                    int old = arr[j]-'0';

                    char prev = (char)(((old-1+10) % 10)+'0');
                    arr[j] = prev;
                    String str1 = new String(arr);
                    if(!set.contains(str1) && !visitedSet.contains(str1)){
                        queue.offer(str1);
                        visitedSet.add(str1);
                    }

                    char next = (char)(((old+1)%10)+'0');
                    arr[j] = next;
                    String str2 = new String(arr);
                    if(!set.contains(str2) && !visitedSet.contains(str2)){
                        queue.offer(str2);
                        visitedSet.add(str2);
                    }

                    arr[j] = (char)(old+'0');
                }
            }
            level++;
        }

        return -1;

    }
}