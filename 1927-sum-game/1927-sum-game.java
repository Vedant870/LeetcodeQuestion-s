class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int cnt1 = 0, cnt2 = 0;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < n/2; i++){
            if(num.charAt(i) == '?'){
                cnt1++;
            }else{
                sum1 += (num.charAt(i) - '0');
            }
            if(num.charAt(i + n/2) == '?'){
                cnt2++;
            }else{
                sum2 += (num.charAt(i + n/2) - '0');
            }
        }
        int cnt = Math.abs(cnt1 - cnt2);
        if(cnt % 2 == 1){
            return true;
        }
        if(cnt1 >= cnt2 && sum1 > sum2){
            return true;
        }
        if(cnt2 >= cnt1 && sum2 > sum1){
            return true;
        }
        int sum = Math.abs(sum1 - sum2);
        if(cnt == 0){
            return !(sum == 0);
        }
        if(sum % 9 == 0 && sum > 0){
            return !( sum == (9 * cnt)/2);
        }
        return true;
    }
}