class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }
            else list.add(nums2[j++]);
        }
        while(i < nums1.length){
            list.add(nums1[i++]);
        }
        while(j < nums2.length){
            list.add(nums2[j++]);
        }

        int n = list.size();
        if(n%2 == 0){
            double result = (double)(list.get(n/2) + list.get(n/2-1))/2;
            return result;
        }
        return list.get(n/2);
    }
}
