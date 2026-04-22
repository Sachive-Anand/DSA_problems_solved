class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int start,String s,List<String> curr,List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                curr.add(s.substring(start,end+1));
                //move forward
                backtrack(end+1,s,curr,res);
                //backtrack
                curr.remove(curr.size()-1);

            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
