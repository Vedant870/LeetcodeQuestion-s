class Solution {
    public int totalNumbers(int[] digits) {
        int[] nums = new int[10];
        int count = 0;
        for(int i = 0;i<digits.length;i++){
              nums[digits[i]]++;
        }
        for(int i = 100;i<1000;i=i+2){
            boolean evenexist = true;
            int a = i%10;
            int b = (i/10)%10;
            int c = i/100;
            if(--nums[a]<0)evenexist = false;
            if(--nums[b]<0)evenexist = false;
            if(--nums[c]<0)evenexist = false;
            nums[a]++;
            nums[b]++;
            nums[c]++;
            if(evenexist)count++;
        }
        return count;
    }
}