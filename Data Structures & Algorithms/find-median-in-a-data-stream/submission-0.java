class MedianFinder {
    List<Double> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add((double)num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int n = list.size();

        if(n%2 == 0){
            double result = (list.get(n/2) + list.get(n/2-1))/2;
            return result;
        }
        return list.get(n/2);
    }
}
