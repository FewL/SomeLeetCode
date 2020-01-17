public class Solution{
    public String intToRoman(int num){
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1}
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}

        StringBuilder ret = new StringBuilder();
        for(int i=0;i<13;i++){
            while(num>=nums[i]){
                num-=nums[i];
                ret.append(romans[i]);
            }
        }

        return ret.toString();
    }
}