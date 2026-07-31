class Solution {
    public int minimumPushes(String word) {
        int arr[]=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        int cnt=0;
        int fact=0;
        int round=1;
        for(int i=25;i>=0;i--){
           cnt+=arr[i]*round;
           fact++;
           if(fact%8==0){
            round++;
           }
        }
        return cnt;
    }
}