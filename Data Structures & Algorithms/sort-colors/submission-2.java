class Solution {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void merge(int l, int m, int r, int[] nums){
        int n1 = m-l+1;
        int n2 = r-m;

        int[] left = new int[n1];
        for(int i=0 ; i<n1 ; i++){
            left[i] = nums[l+i];
        }
        int[] right = new int[n2];
        for(int i=0 ; i<n2 ; i++){
            right[i] = nums[m+1+i];
        }

        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                nums[k++] = left[i++];
            }
            else{
                nums[k++] = right[j++];
            }
        }
        while(i < n1){
            nums[k++] = left[i++];
        }
        while(j < n2){
            nums[k++] = right[j++];
        }
    }
    public void mergeSort(int left, int right, int[] nums){
        if(left >= right) return;

        int mid = left + (right-left) / 2;

        mergeSort(left, mid, nums);
        mergeSort(mid+1, right, nums);

        merge(left, mid, right, nums);
    }
    public void sortColors(int[] nums) {
        mergeSort(0, nums.length-1, nums);


        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     int minIndex = i;
        //     for(int j=i+1 ; j<n ; j++){
        //         if(nums[j] < nums[minIndex]){
        //             minIndex = j;
        //         }
        //     }
        //     swap(i, minIndex, nums);
        // }
        


        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         if(nums[j] < nums[i]){
        //             swap(i, j, nums);
        //         }
        //     }
        // }
    }
}