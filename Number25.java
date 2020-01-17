public ListNode reverseKGrounp(ListNode head,int k){
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode end = dummy;

    while(end.next!=null){ 
        for(int i=0;i<k&&end!=null,i++)    
            end=end.next;
        if(end==null) break;
        ListNode start = pre.next;
        ListNode next = end.next
        end.next = null;
        pre.next = reverse(start);
        start.next = next;      //本来是null,指向next
        pre = start;
        end = pre;
    }
    return dummy.next;
}

private ListNode reverse(ListNode){
    ListNode pre=null;
    ListNode curr = head;
    while(curr!=null){
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}