// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode temp = dummy;
//         while(temp.next != null && temp.next.next != null) {
//             ListNode start = temp.next;
//             ListNode end = temp.next.next;
//             temp.next = end;
//             start.next = end.next;
//             end.next = start;
//             temp = start;
//         }
//         return dummy.next;
//     }
// }

// //way2
// class Solution{
//     public ListNode swapPairs(ListNode head){
//         if(head==null||head.next==null)
//             return head;
        
//         ListNode next = head.next;
//         head=swapPairs(next.next);
//         next.next=head;
//         return next;
//     }
// }

import java.util.*;
//way3
class Number24{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        head=reverse(head,2);
        System.out.print(head.val+""+head.next.val/*+""+head.next.next.val+""+head.next.next.next.val*/);
        System.out.println();
    }
    public static ListNode reverse(ListNode head,int len){
        if(len==1)
            return head;
        //找到end
        ListNode end=head;
        int step = len-1;
        while(end!=null&&step>0){
            end=end.next;
            step--;
        }
        if(head==null)
            return head;
        end.next=reverse(head,len-1);
        head=null;
        return end;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}