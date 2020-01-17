//方法一:按行排序，追踪算法。
class Solution{
    public String convert(String s, int numRows){
        if(numRows==1)return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++)
            rows.add(new StringBuilder());
    }

    int curRow=0;
    boolean goingDown=false;

    for(char c: s.toCharArray()){
        rows.get(curRow).append(c);
        if(curRow==0||curRow==numRows-1)s
            goingDown=!goingDown;
        curRow += goingDown?1:-1;
    }

    StringBuilder ret = new StringBuilder();
    for(StringBuilder row:rows)
        ret.append(row);
    return ret.toString();
}

//方法二
class Solution{
    public String convert(String s,int numRows){
        if (numRows==1)return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cyclen= 2*numRows-2;

        for (int =0;i<numRows;i++){
            for(int j=0;j+i<n;j+=cyclen){
                ret.append(s.charAt(j+i))
                if(i!=0&&i!=numRows-1&&j+cyclen-i<n)
                    ret.append(s.charAt(j+cyclen-i));
            }
        }
        return ret.toString();
    }
}