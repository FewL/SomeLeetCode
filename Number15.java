class Solution{
    public static List<list<Integer>> threeSum(int[] nums){
        List<List<Integer>> ret = new ArrayList();
        if(nums==null||nums.length<3)return ret;
        int length=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            if(nums[i]>0)break;
            //去重
            if(i>0&&nums[i]==nums[i-1]) continue;
            int L = i+1;
            int R = length-1;
            while(L<R){
                int sum=nums[i]+nums[L]+nums[R];
                if(sum==0){
                    ret.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R&&nums[L]==nums[L+1]) L++;
                    while(L<R&&nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if(sum>0)
                    R--;
                else if(sum<0)
                    L++;
            }
        }
        return ret;
    }
}