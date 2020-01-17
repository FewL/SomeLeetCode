class Solution {
    public int divide(int dividend, int divisor) {
        boolean signal = (dividend>0)^(divisor>0);
        dividend=fabs(dividend);
        divisor=fabs(divisor);
        int res=0;
        while(dividend<=divisor){
            int temp_result=-1;
            int temp_divisor=divisor;
            while(dividend<=(temp_divisor<<1)){
                //因为-3<<30+1满足小于dividend(-2^31),但不能再进了
                if(temp_divisor<=(Integer.MIN_VALUE>>1))break;
                temp_result<<=1;
                temp_divisor<<=1;
            }
            dividend-=temp_divisor;
            res+=temp_result;
        }
        if(!signal){
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            res=-res;
        }
        return res;
    }
    private int fabs(int x){
        return x>0?-x:x;
    }
}