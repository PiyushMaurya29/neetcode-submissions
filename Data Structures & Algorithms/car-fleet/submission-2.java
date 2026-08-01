class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<double[]> pairList = new ArrayList<>(); // Position and TimeTaken
        for(int i=0 ; i<n ; i++){
            double timeTaken = (double)(target-position[i]) / speed[i];
            pairList.add(new double[]{position[i], timeTaken});
        }

        Collections.sort(pairList, (a,b) -> Double.compare(a[0], b[0]));
        Stack<double[]> stack = new Stack<>();

        for(int i=0 ; i<n ; i++){
            // If the timeTaken by the previous car is less than the current car it will cause a fleet of car
            while(!stack.isEmpty() && stack.peek()[1]<=pairList.get(i)[1]){
                stack.pop();
            }
            stack.push(pairList.get(i));
        }
        return stack.size();
    }
}
