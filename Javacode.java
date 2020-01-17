class Solution{
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer>map = new HashMap<>();
        //推入Hash表
        for(int i=0;i<num.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containKey(complement)&&map.get(complement)!=i){
                return new int[] {i,map.get(complement)};//返回新数组，居然不会清空内存（java的new的用法）。
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

//一遍hash
class Solution{
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>{};
        for(int i=0;i<num.length;i++){
            int complement=target-nums[i];
            if(map.containKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

//两个链表相加
public ListNode addTwoNumbers(ListNode l1,ListNode l2){
    ListNode dummyHead = new ListNode(0);
    ListNode p=l1,q=l2,curr=dummyHead;
    int carry=0;
    while(p!=null||q!=null){
        int x = (p==null)? 0:p;
        int y = (q==null)? 0:q;
        sum=x+y+carry;
        carry=sum/10;
        curr.next=new ListNode(sum%10);
        curr=curr.next;
        if(p!=null) p=p.next;
        if(q!=null) q=q.next;
    }
    if(carry>0){
        curr.next=new ListNode(carry);
    }
    return dummyHead.next;
}