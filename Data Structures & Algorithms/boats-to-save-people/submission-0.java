class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int left=0, right=n-1;

        int resultCount = 0;
        while(left < right){
            if(people[left]+people[right] <= limit){
                left++;
                right--;
            }
            else right--;
            resultCount++;
        }
        if(left == right) resultCount++;
        return resultCount;


        // int resultCount = 0;
        // int index = 0;
        // while(index < people.length){
        //     if(index<people.length-1 && people[index]+people[index+1]<=limit){
        //         index += 2;
        //     }
        //     else{
        //         index++;
        //     }
        //     resultCount++;
        // }
        // return resultCount;
    }
}