import java.util.*;
public class Solution {
    public static boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        int len=s.length();

        Stack<String> st = new Stack<String>(); 

        for(int i=0;i<len;i++){
            if(map.containsKey(String.valueOf(s.charAt(i)))){
                st.push(String.valueOf(s.charAt(i)));
                System.out.println("push!!!");
                continue;
            }
            if(map.containsValue(String.valueOf(s.charAt(i)))&&!st.empty()){
                char curchar=st.pop().charAt(0);
                System.out.println("you come,pop!!!"+s.charAt(i));
                if(map.get(String.valueOf(curchar)).charAt(0)==s.charAt(i))
                    continue;
                else
                    return false;
            }
            return false;
        }
        if(st.empty())
            return true;
        else
            return false;
    }

    public static void main(String []args){
        System.out.println(isValid("{([])}{}{}{}"));
    }
}