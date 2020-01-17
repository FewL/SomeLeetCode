public List<Integer> findSubstring(String s,String[] words){
    List<Integer> res = new ArrayList<Integer>();
    int wordNum = words.length;
    if(wordNum == 0)
        return res;
    int wordlen=words[0].length();
    HashMap<String,Integer> allwords = new HashMap<String,Integer>();
    for(String word:words){
        int val= allwords.getOrDefault(w,0);
        allwords.put(w,val+1);
    }
    for(int i=0;i<s.length()-wordNum*wordlen+1;i++){
        HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
        int num=0;
        while(num<wordNum){
            String word = s.substring(i+num*wordlen,i+(num+1)*wordlen);
            if(allwords.containKey(word)){
                int value= hashmap.getOrDefault(word,0);
                hashmap.put(word,value);
                if(hashmap.get(word)>allwords.get(word))
                    break;
            }
            else
                break;
            num++;
        }
        if(num==wordNum)
            res.add(i);
    }
    return res;
}