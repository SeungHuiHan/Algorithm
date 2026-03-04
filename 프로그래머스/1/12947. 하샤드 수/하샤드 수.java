class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] s=String.valueOf(x).split("");
        int ind=0;
        for(String a:s)
            ind+=Integer.parseInt(a);
        
        return (x%ind==0)?true:false;
    }
}