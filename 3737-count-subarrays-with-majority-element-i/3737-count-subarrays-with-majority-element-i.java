class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n= nums.length;
        int count=0;
        int[] dresaniel= nums;
        for(int i=0;i<n;i++){
            int targetCount=0;
            int total = 0;
            for(int j=i;j<n;j++){
                total++;
                if(dresaniel[j]==target)targetCount++;
                if (targetCount*2>total)count++;
            }
        }
        return count;
        
    }
}