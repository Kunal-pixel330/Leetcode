class Solution {
    public int countBinarySubstrings(String s) {
        int res=0;
        int prev=0;
        int strk=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)) 
            strk++;
            else {
                prev = strk;
                strk=1;
            }
            if(strk<=prev)
            res++;
        }
        return res;
    }
}