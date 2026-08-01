class Solution {
    public double solve(double x, int n){
        if(n == 0) return 1;
        double ans = solve(x, n/2);
        if(n%2 == 0){
            return ans * ans;
        }
        else{
            return x * ans * ans;
        }
    }
    public double myPow(double x, int n) {
        boolean isNegative = n < 0;
        if(isNegative) n = n*-1;

        double result = solve(x, n);
        // if(isNegative) return 1/result;
        // return result;
        return isNegative ? 1/result : result;
    }
}
