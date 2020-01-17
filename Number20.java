class Solution{
    private HashMap<Character,Character> mappings;

    public Solution(){
        this.mappings = new HashMap<Character,Character>();
        this.mappings.put(')','(');
        this.mappings.put(']','[');
        this.mappings.put('}','{');
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(this.mappings.containsKey(c)){
                char topElement = stack.empty()?'#':stack.pop();

                if(topElement!=this.mappings.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
}

//DummyNode
public ListNode removeNthFromEnd(ListNode head,int n){
    ListNode dummy = new ListNode(0);
    dummy.next=head;
    int length=0;
    ListNode first=head;
    while(first!=null){
        length++;
        first=first.next();
    }
    length-=n;
    first=dummy;
    while(length>0){
        length--;
        first=first.next;
    }
    first.next=first.next.next;
    return dummy.next;
}


//way2
public ListNode removeNthFromEnd(ListNode head,int n){
    //默认n的大小小于length
    ListNode dummy=new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for(int i=0;i<n+1;i++){
        first=first.next();
    }
    while(first!=null){
        first=first.next();
        second=second.next();
    }
    second.next=second.next.next;
    return dummy.next;
}