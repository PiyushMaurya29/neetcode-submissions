class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            x = x*-1;
            isNegative = true;
        }

        long revNum = 0;
        while(x > 0){
            int rem = x%10;
            revNum = revNum*10 + rem;
            if(revNum<=Integer.MIN_VALUE || revNum>=Integer.MAX_VALUE){
                return 0;
            }
            x /= 10;
        }
        if(isNegative) revNum *= -1;
        return (int)revNum;
    }
}
