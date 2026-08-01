class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] pair = new double[n][2];
        for(int i=0 ; i<n ; i++){
            pair[i][0] = (double) position[i];
            // Time taken by car to reach the target
            pair[i][1] = (double)(target-position[i])/speed[i];
        }

        // Sort by position
        Arrays.sort(pair, (a,b) -> Double.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && stack.peek()<=pair[i][1]){
                stack.pop();
            }
            stack.push(pair[i][1]);
        }
        return stack.size();
    }
}
