class MedianFinder {
    PriorityQueue<Double> leftMaxHeap;
    PriorityQueue<Double> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        double curr = (double)(num);
        if(leftMaxHeap.isEmpty()){
            leftMaxHeap.offer(curr);
        }
        else if(curr <= leftMaxHeap.peek()){
            leftMaxHeap.offer(curr);
            if(leftMaxHeap.size()-rightMinHeap.size() > 1){
                rightMinHeap.offer(leftMaxHeap.poll());
            }
        }
        else{
            rightMinHeap.offer(curr);
            if(rightMinHeap.size() > leftMaxHeap.size()){
                leftMaxHeap.offer(rightMinHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int n = leftMaxHeap.size() + rightMinHeap.size();
        if(n%2 == 0){
            double result = (leftMaxHeap.peek()+rightMinHeap.peek())/2;
            return result;
        }
        return leftMaxHeap.peek();
    }
}


// class MedianFinder {
//     List<Double> list;
//     public MedianFinder() {
//         list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add((double)num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
//         int n = list.size();

//         if(n%2 == 0){
//             double result = (list.get(n/2) + list.get(n/2-1))/2;
//             return result;
//         }
//         return list.get(n/2);
//     }
// }

