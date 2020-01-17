class Solution{
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0) return null;
        return solve(lists,0,lists.length-1);
    }

    private ListNode solve(ListNode[] lns,int left,int right){
        if(left==right) return lns[right];

        int mid=(left+right)>>1;
        ListNode lNode = solve(lns,left,mid);
        ListNode rNode = solve(lns,mid+1,right);

        return merge(lNode,rNode)
    }

    private ListNode merge(ListNode node1,ListNode node2){
        if(node1==null) return node2;
        if(node2==null) return node1;

        if(node1.val<node2.val){
            node1.next=merge(node1.next,node2);
            return node1;
        }else{
            node2.next=merge(node1,node2.next);
            return node2;
        }
    }
}


//笨办法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length<1) return null;
        if(lists.length<2) return lists[0];       
        int len=lists.length;
        ListNode dummy = new ListNode(0);
        dummy.next=lists[0];
        for(int i=1;i<len;i++){
            dummy.next=mergeTwoLists(dummy.next,lists[i]);
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curNode=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curNode.next=new ListNode(l1.val);
                curNode=curNode.next;
                l1=l1.next;
            }else{
                curNode.next=new ListNode(l2.val);
                curNode=curNode.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            curNode.next=new ListNode(l1.val);
            curNode=curNode.next;
            l1=l1.next;
        }
        while(l2!=null){
            curNode.next=new ListNode(l2.val);
            curNode=curNode.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}