class Solution {
    public List<Integer> getMergedList(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }
            else{
                list.add(nums2[j++]);
            }
        }
        while(i < nums1.length){
            list.add(nums1[i++]);
        }
        while(j < nums2.length){
            list.add(nums2[j++]);
        }
        return list;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = getMergedList(nums1, nums2);
        int n = list.size();
        return n%2 == 0 ? (list.get(n/2)+list.get(n/2-1))/2.0 : list.get(n/2);


        // List<Integer> list = new ArrayList<>();
        // for(int num : nums1){
        //     list.add(num);
        // }
        // for(int num : nums2){
        //     list.add(num);
        // }
        // Collections.sort(list);
        // int n = list.size();
        // return n%2 == 0 ? (list.get(n/2)+list.get(n/2-1))/2.0 : list.get(n/2);
    }
}
